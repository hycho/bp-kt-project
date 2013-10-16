package egovframework.kakaotheme.util.dom;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DocumentHelper {
	
	/**
	 * File Path의 파일을 org.w3c.dom.Documet 객체로 변환 해서 리턴합니다.
	 * @param filePath
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDocument(String filePath) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory docFactory = null;
	    DocumentBuilder docBuilder = null;
	    Document doc = null;

	    docFactory = DocumentBuilderFactory.newInstance();
	    docBuilder = docFactory.newDocumentBuilder();
	    doc = docBuilder.parse(new BufferedInputStream(new FileInputStream(filePath)));

	    return doc;
	}
	   
	/**
	 * File을 org.w3c.dom.Documet 객체로 변환 해서 리턴합니다.
	 * @param file
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDocument(File file) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;

		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.parse(new BufferedInputStream(new FileInputStream(file)));

		return doc;
	}
   
	/**
	 * InputStream을 org.w3c.dom.Documet 객체로 변환 해서 리턴합니다.
	 * @param ios
	 * @return
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDocument(InputStream  ios) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;

		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.parse(new BufferedInputStream(ios));

		return doc;
	}
	
	/**
	 * html형태의 String을 org.w3c.dom.Document 객체로 변환해서 리턴합니다.
	 * @param htmlString
	 * @return
	 * @throws ParserConfigurationException
	 */
	public static Document getDocumentToHtml(String html) throws ParserConfigurationException {
		HtmlCleaner cleaner = new HtmlCleaner();
	    CleanerProperties props = cleaner.getProperties();
	    props.setUseCdataForScriptAndStyle(true);
	    props.setOmitComments(true);
	    TagNode cnode = cleaner.clean(html);

	    DomSerializer ds = new DomSerializer(props);
	    Document document = ds.createDOM(cnode);

	    return document;
	}
	
	/**
	 * String을 org.w3c.dom.Document 객체로 변환해서 리턴합니다.
	 * @param htmlString
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document getDocumentToString(String str) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc = null;

		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.parse(new ByteArrayInputStream(str.getBytes("UTF-8")));

		return doc;
	}
	
	/**
	 * org.w3c.dom.Element를 String으로 리턴합니다.
	 * @param doc
	 * @param EncodeType
	 * @return
	 * @throws TransformerException
	 */
	public static String getStringToElement(Element doc, String EncodeType) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, EncodeType);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);

		return writer.toString();
	}
}
