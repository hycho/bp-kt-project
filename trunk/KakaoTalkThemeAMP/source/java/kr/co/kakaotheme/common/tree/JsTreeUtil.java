package kr.co.kakaotheme.common.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsTreeUtil {
	
	/**
	 * nodeList를 받아서 JsTree의 JSONObject로 변형
	 * 
	 * @param nodeList
	 * @return JSON 형태 String
	 * @throws JSONException
	 * @see JSONObject#put(String, Object)
	 * @see JSONArray#put(Object)
	 * @see HashMap#put(String, Object)
	 * 
	 */
	public static String makeJSONString(Collection<JsTreeBean> nodeList) throws JSONException{
		return makeJSONString(nodeList,null);
	}
	
	/**
	 * nodeList와 ROOT node명을 받아서 JsTree의 JSONObject로 변형
	 * @param nodeList
	 * @param rootNodeTitle
	 * @return JSON 형태 String
	 * @throws JSONException
	 * @see JSONObject#put(String, Object)
	 * @see JSONArray#put(Object)
	 * @see HashMap#put(String, Object)
	 */
	public static String makeJSONString(Collection<JsTreeBean> nodeList,String rootNodeTitle) throws JSONException{
		if(("".equals(rootNodeTitle) || rootNodeTitle == null) && (nodeList==null || nodeList.size()==0))return "";
		Map<String,Object> map = new HashMap();
		JSONArray jsonArray = new JSONArray();
		for(JsTreeBean treeNode : nodeList ){
			JSONObject node = new JSONObject();
			JSONObject attr = new JSONObject();
			JSONObject data = new JSONObject();
			attr.put("id", treeNode.getNodeId());
			attr.put("type", treeNode.getType());
			attr.put("rel", treeNode.getType());
			attr.put("thumbnail", treeNode.getThumbNail());
			attr.put("url", treeNode.getUrl());
			attr.put("title", treeNode.getNodeText());
			data.put("title", treeNode.getNodeText());
			node.put("attr",attr);
			node.put("data",data);
			map.put((String)treeNode.getNodeId(), node);
			
			if("ROOT".equals(treeNode.getParentNodeId())){
				jsonArray.put(node);
				continue;
			}
			
			JSONObject parentNode =(JSONObject) map.get(treeNode.getParentNodeId());
			if(parentNode==null) continue;
			parentNode.append("children", node);
			parentNode.put("state", "closed");
		}
		
		
		if(!"".equals(rootNodeTitle) && rootNodeTitle != null ){
		
			JSONObject root = new JSONObject();
			JSONObject attr = new JSONObject();
			JSONObject data = new JSONObject();
			data.put("title", rootNodeTitle);
			attr.put("id", "root");
			attr.put("rel", "F");
			attr.put("thumbnail", "");
			root.put("attr",attr);
			root.put("data",data);
				if(jsonArray.length()!=0){
					root.append("children",(jsonArray.length()==1)?jsonArray.getJSONObject(0) : jsonArray);
					root.put("state", "closed");
				}
				return root.toString();
		}else{
			if(jsonArray.length()==0) return "";
			if(jsonArray.length()==1) return jsonArray.getJSONObject(0).toString();
			return jsonArray.toString();
		}
		
	}

}
