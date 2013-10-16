package egovframework.kakaotheme.util.transform;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SqlResultDataTrans {
	
	/**
	 * DataBase ResultSet 값을 Map 형태로 받아 옵니다.
	 * @param rs
	 * @return
	 * map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents list (
	 * 			map (
	 * 				String : 컬럼명,
	 * 				Object : 컬럼값
	 * 			)
	 * 		)
	 * )
	 * @throws Exception
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

			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();

				for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
					if(rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
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
	
	/**
	 * DataBase ResultSet 값을 Map 형태로 받아 옵니다.
	 * @param rs
	 * @return
	 *map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents map (
	 * 			String : 키 컬럼값,
	 * 			map (
	 * 				String : 컬럼명,
	 * 				Object : 컬럼값
	 * 			)
	 * 		)
	 * )
	 * @throws Exception
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

			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            	if(rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
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

	/**
	 * DataBase ResultSet 값을 Map 형태로 받아 옵니다.
	 * @param rs
	 * @return
	 * map (
	 *		titles list (
	 * 			String : 키 컬럼값
	 * 		),
	 *		map (
	 *			String : 키  컬럼값,
	 *			Object : 값  컬럼값
	 * 		)
	 * )
	 * @throws Exception
	 */
	public static Map<String, Object> transDatasMap(ResultSet rs, String key_field, String value_field, boolean returnTitles) throws Exception {
	   Map<String, Object> data = new HashMap<String, Object>();
	   Collection<String> titles = new ArrayList<String>();
	   Map<String, Object> contents = new HashMap<String, Object>();

	   try {
		   while (rs.next()) {
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

   /**
	 * DataBase ResultSet 값을 Map 형태로 받아 옵니다.
	 * @param rs
	 * @return
	 * Map (
	 *		titles List (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents Map (
	 * 			String : 분류키  컬럼값,
	 * 			classified_data List (
	 * 				Map (
	 * 					String : 컬럼명,
	 * 					Object : 컬럼값
	 * 				)
	 * 			)
	 * 		)
	 * )
	 * @throws Exception
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

		   while (rs.next()) {
			   Map<String, Object> m = new HashMap<String, Object>();

			   for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
				   if(rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
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

   /**
	 * DataBase ResultSet 값을 Map 형태로 받아 옵니다.
	 * @param rs
	 * @return
	 * map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents map (
	 *			String : 컬럼명,
	 *			Object : 컬럼값
	 * 		)
	 * )
	 * @throws Exception
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
   					if(rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
   						StringBuffer output = new StringBuffer();
   						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
   						char[] buffer = new char[1024];
   						int byteRead;
   						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
   							output.append(buffer, 0, byteRead);
   						}
   						input.close();

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

   /**
	 * <pre>
    * Clob 데이터를 읽어 String으로 변환 한다.
    * </pre>
	 * @param reader Clob데이터
	 * @return String Clob에 데이터
	 * @throws IOException
	 */
   	public static String readClobData(Reader reader) throws IOException {
   		StringBuffer data = new StringBuffer();
   		char[] buf = new char[1024];
   		int cnt = 0;
   		if(null != reader) {
   			while ((cnt = reader.read(buf)) != -1) {
   				data.append(buf, 0, cnt);
   			}
   		}
   		return data.toString();
   	}

}
