package egovframework.kakaotheme.util.transform;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestParamDataTrans {

	/**
	 * HttpServletRequest의 parameter값을 Map<String, Object> 형으로 변경해서 리턴합니다.
	 * @param request
	 * @return map ( String : 파라메터 키, Object : 파라메터 값 )
	 * @throws Exception
	 */
	public static Map<String, Object> transDataMap(HttpServletRequest request) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			for (Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
				String name = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(name);
				parameters.put(name, values.length > 1 ? values : values[0]);
			}
			
			return parameters;
		} catch (Exception e) {
			throw e;
		} finally {}
	}

}
