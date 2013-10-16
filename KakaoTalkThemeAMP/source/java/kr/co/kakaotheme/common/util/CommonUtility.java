package kr.co.kakaotheme.common.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.extensions.webscripts.WebScriptRequest;

/**
 * @author hajimaro
 *
 */
public class CommonUtility {
	
    public static Class<?> loadClass(String className) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		classLoader = (classLoader == null) ? ClassLoader.getSystemClassLoader() : classLoader;
		
    	Class<?> clazz = classLoader.loadClass(className);
        return (clazz == null) ? Class.forName(className) : clazz;
    }

    /*
	 *map (
	 *		titles list (
	 * 			String : 컬럼�?
	 * 		),
	 * 		contents list (
	 * 			map (
	 * 				String : 컬럼�?
	 * 				Object : 컬럼�?
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasList(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Collection<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	
            	contents.add(m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}
	
	/*
	 *map (
	 *		titles list (
	 * 			String : 컬럼�?
	 * 		),
	 * 		contents map (
	 * 			String : ??컬럼�?
	 * 			map (
	 * 				String : 컬럼�?
	 * 				Object : 컬럼�?
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasMap(ResultSet rs, String key_field) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	
            	contents.put(String.valueOf(m.get(key_field)), m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *		titles list (
	 * 			String : ??컬럼�?
	 * 		),
	 *		map (
	 *			String : ?? 컬럼�?
	 *			Object : �? 컬럼�?
	 * 		)
	 *)
	 */
	public static Map<String, Object> transDatasMap(ResultSet rs, String key_field, String value_field, boolean returnTitles) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            while(rs.next()) {
            	contents.put(String.valueOf(rs.getObject(key_field)), rs.getObject(value_field));
            }
            
            titles.addAll(contents.keySet());
            
            data.put("titles", titles);
            data.put("contents", contents);

            return (returnTitles) ? data : contents;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *Map (
	 *		titles List (
	 * 			String : 컬럼�?
	 * 		),
	 * 		contents Map (
	 * 			String : 분류?? 컬럼�?
	 * 			classified_data List (
	 * 				Map (
	 * 					String : 컬럼�?
	 * 					Object : 컬럼�?
	 * 				)
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasClassifiedList(ResultSet rs, String classify_key_field) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<Object, Object> contents = new HashMap<Object, Object>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	if(!contents.containsKey(m.get(classify_key_field)))
            		contents.put(m.get(classify_key_field), new ArrayList<Map<String, Object>>());
            	
            	((Collection<Object>) contents.get(m.get(classify_key_field))).add(m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *		titles list (
	 * 			String : 컬럼�?
	 * 		),
	 * 		contents map (
	 *			String : 컬럼�?
	 *			Object : 컬럼�?
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDataMap(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            rsmd = rs.getMetaData();
            
            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());

            if(rs.next())
            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						/*
						BufferedReader reader = new BufferedReader(rs.getCharacterStream(rsmd.getColumnName(colIdx)));
						String line = null;
						StringBuffer text = new StringBuffer();
						while ((line = reader.readLine()) != null)
							text.append(line).append("\r\n");

						cf)
						Reader reader = new StringReader(data.getContent());
						pstmt.setCharacterStream(2, reader, data.getContent().length());
						*/
						
						contents.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		contents.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *	String : ?�라미터�?
	 *	Object : ?�라미터�?
	 * )
	 */
	public static Map<String, Object> transDataMap(HttpServletRequest request) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();

        try {
        	//java.lang.IllegalStateException: No modifications are allowed to a locked ParameterMap
        	/*
            Map<String, String[]> parameterMap = request.getParameterMap();
            for(String name : parameterMap.keySet()) {
            	String[] values = parameterMap.get(name);
            	parameters.put(name, values.length > 1 ? values : values[0]);
            }
        	 */
            for(Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
            	String name = (String) enumeration.nextElement();
            	String[] values = request.getParameterValues(name); 
            	parameters.put(name, values.length > 1 ? values : values[0]);
            }
            return parameters;
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	/**
	 * 쿠키�?추�? ?�킨??
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param domain 
	 * @param path
	 * @param maxAge 
	 * @throws Exception
	 */
	public static void setCookie(HttpServletResponse response,String cookieName, String cookieValue, String domain, String path,int maxAge) throws Exception {
		Cookie cookie = new Cookie(cookieName, java.net.URLEncoder.encode(cookieValue.toString(),"UTF-8"));
		if (domain != null)
			cookie.setDomain(domain);
		if (path != null)
			cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String CookieName) throws Exception {
		Cookie [] cookies = request.getCookies();
		if(cookies==null) return null;
		String value = "";
		for(int i=0;i<cookies.length;i++) {
			if(CookieName.equals(cookies[i].getName())) {
				value = java.net.URLDecoder.decode(cookies[i].getValue(),"UTF-8");
				break;
			}
		}
		return value;
	}
	
	/**
	 * ?�재 ?�버 ?�을 �?��?�니??
	 *
	 * @return String : ?�재 ?�버 ??문자?�로 반환(yyyy)
	 */
	public static String getCurrentServerYear(){
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy");
		currTime = dateFormat.format(date);
		return currTime;
	}


	/**
	 * ?�재 ?�버 ?�일??�?��?�니??
	 *
	 * @return String : ?�재 ?�버 ??문자?�로 반환(MMdd)
	 */
	public static String getCurrentServerMonthDay(){
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMdd");
		currTime = dateFormat.format(date);
		return currTime;
	}



	/**
	 * ?�재 ?�버 ?�간??�?��?�니??
	 *
	 * @return String : ?�재 ?�버?�간??8?�리 문자?�로 반환(yyyyMMdd)
	 */
	public static String getCurrentServerTime(){
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
		currTime = dateFormat.format(date);
		return currTime;
	}


	/**
	 * ?�재 ?�버 ?�간??�?��?�니??
	 *
	 * @return String : ?�재 ?�버?�간??14?�리 문자?�로 반환(yyyyMMddHHmmss)
	 */
	public static String getCurrentServerTime(long time){
		java.sql.Date date = new java.sql.Date(time);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String temp = dateFormat.format(date);
		return temp;
	}


	/**
	 * ?�재 ?�버 ?�간??�?��?�니??
	 *
	 * @return String : ?�재 ?�버?�간??17?�리 문자?�로 반환(yyyyMMddHHmmssSSS)
	 */
	public static String getCurrentServerTimeMillis(){
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}
	
	/**
	 * ?�재 ?�버 ?�간??�?��?�니??
	 *
	 * @return String : ?�재 ?�버?�간??14?�리 문자?�로 반환(yyyyMMddHHmmss)
	 */
	public static String getCurrentServerTimes(){
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}
	
	/**
	 * <pre>
     * Clob ?�이?��? ?�어 String?�로 �?�� ?�다.
     * </pre>
	 * @param reader Clob?�이??
	 * @return String Clob???�이??
	 * @throws IOException
	 */
	public static String readClobData(Reader reader) throws IOException {
	    StringBuffer data = new StringBuffer();
	    char[] buf = new char[1024];
	    int cnt = 0;
	    if (null != reader) {
	        while ( (cnt = reader.read(buf)) != -1) {
	            data.append(buf, 0, cnt);
	        }
	    }
	    return data.toString();
	}
	
}
