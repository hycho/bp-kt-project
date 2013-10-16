package kr.co.kakaotheme.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kr.co.kakaotheme.common.constants.Constants;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.dictionary.DictionaryService;
import org.alfresco.service.cmr.dictionary.PropertyDefinition;
import org.alfresco.service.cmr.model.FileFolderService;
import org.alfresco.service.cmr.model.FileInfo;
import org.alfresco.service.cmr.repository.ContentIOException;
import org.alfresco.service.cmr.repository.ContentWriter;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.search.ResultSet;
import org.alfresco.service.cmr.search.ResultSetRow;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;
import org.alfresco.web.app.servlet.DownloadContentServlet;
import org.springframework.extensions.webscripts.WebScriptRequest;

public class WebScriptUtil {
	
	
	public static void writeContentNode(NodeRef newNodeRef, String mimeType, QName qname, Object content, String Encoding, ServiceRegistry registry) {
		ContentWriter writer = registry.getContentService().getWriter(newNodeRef, qname, true);
		writer.setMimetype(mimeType);
		writer.setEncoding(Encoding);

		if ((content instanceof String))
			writer.putContent((String) content);
		else if ((content instanceof File))
			writer.putContent((File) content);
		else if ((content instanceof InputStream))
			writer.putContent((InputStream) content);
		else
			writer.putContent(new ByteArrayInputStream((byte[]) content));
	}

	public static NodeRef getUuidNodeRef(String uuid, Repository repository) {
		String uuidPath = Constants.URL_SPACESTORE + "/" + uuid;
		return repository.findNodeRef("node", uuidPath.split("/"));
	}

	public static String uploadStringData(String fileName, String extention, InputStream data, NodeRef parentNodeRef, ServiceRegistry registry) throws ContentIOException, IOException {
		String realName = CommonUtility.getCurrentServerTimeMillis() + "." + extention;

		NodeRef createNodeRef = registry.getNodeService().createNode(parentNodeRef, ContentModel.ASSOC_CONTAINS, QName.createQName(NamespaceService.CONTENT_MODEL_1_0_URI, realName), ContentModel.TYPE_CONTENT).getChildRef();

		Map<QName, Serializable> props = new HashMap<QName, Serializable>();
		props.put(ContentModel.PROP_NAME, realName);
		registry.getNodeService().setProperties(createNodeRef, props);

		ContentWriter writer = registry.getContentService().getWriter(createNodeRef, ContentModel.TYPE_CONTENT, true);
		if (extention != null && !extention.equals("")) {
			writer.setMimetype(registry.getMimetypeService().guessMimetype(realName));
		}
		writer.putContent(data);

		data.close();

		return DownloadContentServlet.generateBrowserURL(createNodeRef, realName);
	}

	public static NodeRef createDataNode(NodeRef parentNodeRef, String nodeName, String mimeType, String encoding, String Contents, QName qname, Map<QName, Object> p_props, ServiceRegistry registry) {
		FileInfo fileInfo = registry.getFileFolderService().create(parentNodeRef, nodeName, qname);

		NodeRef nodeRef = fileInfo.getNodeRef();

		Map<QName, Serializable> props = new HashMap<QName, Serializable>();
		props.put(ContentModel.PROP_NAME, nodeName);
		registry.getNodeService().addProperties(nodeRef, props);

		ContentWriter writer = registry.getContentService().getWriter(nodeRef, ContentModel.PROP_CONTENT, true);
		writer.setMimetype(mimeType);
		writer.setEncoding(encoding);
		writer.putContent(Contents);

		return nodeRef;
	}

	public static NodeRef createNode(NodeRef parentNodeRef, String nodeName, QName qname, Map<QName, Object> p_props, ServiceRegistry registry) {
		FileInfo fileInfo = registry.getFileFolderService().create(parentNodeRef, nodeName, qname);

		NodeRef nodeRef = fileInfo.getNodeRef();

		Map<QName, Serializable> props = new HashMap<QName, Serializable>();
		props.put(ContentModel.PROP_NAME, nodeName);
		registry.getNodeService().addProperties(nodeRef, props);

		return nodeRef;
	}

	/**
	 * nodeId로 node를 삭제
	 * 
	 * @param repository
	 * @param nodeService
	 * @param nodeId
	 */
	public static void delNodeRef(Repository repository, NodeService nodeService, String nodeId) {
		String nodePath = Constants.URL_SPACESTORE+"/"+nodeId;
		NodeRef nodeRef = repository.findNodeRef("node", nodePath.split("/"));
		NodeRef parentNodeRef = nodeService.getParentAssocs(nodeRef).get(0).getParentRef();
		nodeService.removeChild(parentNodeRef, nodeRef);
	}
	
	/**
	 * 
	 * nodeId 배열을 넘기면 배열에 있는 노드 삭제
	 * 
	 * @param repository
	 * @param nodeService
	 * @param nodeIds
	 */
	public static void delNodeRefs(Repository repository, NodeService nodeService, String [] nodeIds) {
		for(String nodeId : nodeIds){
			delNodeRef(repository, nodeService, nodeId);
		}
	}
	
	/**
	 * node를 생성시킨다.
	 * 
	 * @param fileFolderService
	 * @param nodeService
	 * @param nodeRef
	 * @param name
	 * @param qname
	 * @return boolean
	 */
	public static boolean makeNodeRef(FileFolderService fileFolderService, NodeService nodeService, NodeRef nodeRef, String name, QName qname) {
		NodeRef trackingRef = nodeService.getChildByName(nodeRef, ContentModel.ASSOC_CONTAINS, name);
		if (trackingRef == null) {
			fileFolderService.create(nodeRef, name, qname);
			return true;
		}
		return false;
	}

	/**
	 * 파라미터를 Map 형태로 변형
	 * 
	 * @param request
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> transDataMap(WebScriptRequest request) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String[] enumeration = request.getParameterNames();
		for (String name : enumeration) {
			String[] values = request.getParameterValues(name);
			parameters.put(name, values.length > 1 ? values : values[0]);
		}
		return parameters;
	}

	/**
	 * 프로퍼티정보와 타입을 넘겨줌
	 * 
	 * @param dictionaryservice
	 * @param properties
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> transDataMapAndType(DictionaryService dictionaryservice, Map<QName, Serializable> properties) {
		
		List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		
		for (QName name : properties.keySet()) {
			Map<String, Object> data = new HashMap<String, Object>();
			String temp = name.getLocalName().replaceAll("-", "");
			
			PropertyDefinition pd = dictionaryservice.getProperty(name);
			
			data.put("key", temp);
			data.put("value", properties.get(name));
			data.put("type", pd.getDataType());
			data.put("uri", name.getNamespaceURI());
			data.put("qname", name.toString());
			
			datas.add(data);
		}
		return datas;
	}
	
	
	 
	
	/**
	 * aspect 정보를 넘김
	 * @param aspects
	 * @return
	 */
	public static List<String> transDataList(Set<QName> aspects) {
		
		List<String> data = new ArrayList<String>();
		
		for (QName name : aspects) {
			data.add(name.toString());
		}
		
		return data;
	}
	
	/**
	 * 프로퍼티를 Map 형태로 변형
	 * 
	 * @param properties
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> transDataMap(Map<QName, Serializable> properties) {
		Map<String, Object> data = new HashMap<String, Object>();
		for (QName name : properties.keySet()) {
			String temp = name.getLocalName().replaceAll("-", "");
			data.put(temp, properties.get(name));
		}
		return data;
	}
	
	/**
	 * 루씬 서치를 통해 나온 결과 노드의 Propertie 정보를 ArrayList 형태로 반환 
	 * @param nodeService
	 * @param results
	 * @return ArrayList<Map<String, Object>>
	 */
	public static ArrayList<Map<String, Object>> transDataList(NodeService nodeService, ResultSet results) {
		ArrayList<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		 for(ResultSetRow row : results){
			 datas.add(transDataMap(nodeService.getProperties(row.getNodeRef())));
		}
		return datas;
	}
	
	public static List<Map<String, Object>> transDataMapAndAllType(NodeRef cubeRef, ServiceRegistry service){
		List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		
		Collection<QName> aspectCollection = service.getNodeService().getAspects(cubeRef);
		Iterator<QName> it = aspectCollection.iterator();
		
		while(it.hasNext()){
			QName aspectQName = it.next();
			datas.addAll(getDataMapAndAspect(cubeRef, aspectQName, service));
			
		}
		return datas;
	}
	
	public static List<Map<String, Object>> getDataMapAndAspect(NodeRef ref, QName aspectQName, ServiceRegistry service){
		List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
		Map<QName, Serializable> refAllProperties = service.getNodeService().getProperties(ref);
		Map<QName, PropertyDefinition> aspectPropDefs = service.getDictionaryService().getAspect(aspectQName).getProperties();
		for(QName propertyQName : aspectPropDefs.keySet()){
			Map<String, Object> data = new HashMap<String, Object>();
		    Serializable value = refAllProperties.get(propertyQName);
		    String temp = propertyQName.getLocalName().replaceAll("-", "");
		    PropertyDefinition pd = service.getDictionaryService().getProperty(propertyQName);
		    if (value != null){
		        data.put("key", temp);
				data.put("value", value);
				data.put("type", pd.getDataType());
				data.put("uri", propertyQName.getNamespaceURI());
				data.put("qname", propertyQName.toString());
		    }else{
		    	 data.put("key", temp);
				 data.put("value", "");
				 data.put("type", pd.getDataType());
				 data.put("uri", propertyQName.getNamespaceURI());
				 data.put("qname", propertyQName.toString());
		    }
		    datas.add(data);
		}
		
		return datas;
	}
	
	
	public static String getDocumentUrl(String mimetype, String uuid, WebScriptRequest request, NodeRef nodeRef, String filename) throws Exception{ 
		String type = "";
		String prefixUrl = "";
		String suffixUrl = "";
		
		prefixUrl = request.getServerPath() + "/share/proxy/alfresco/api/node/workspace/SpacesStore/";
		suffixUrl = "/content/thumbnails/webpreview?c=force";
		
		String url = request.getServerPath() + request.getContextPath() + "/" + DownloadContentServlet.generateBrowserURL(nodeRef, filename);
		
		if(mimetype.startsWith("application/")){
			type = prefixUrl + uuid + suffixUrl;
		}else{
			type = url;
		}
		
		return type;
	}
}
