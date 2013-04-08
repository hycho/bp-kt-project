package egovframework.kakaotheme.util.date;

public class DateTime {

	/**
	 * 현재 서버 년을 가져옵니다.
	 *
	 * @return String : 현재 서버 년 문자열로 반환(yyyy)
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
	 * 현재 서버 월일을 가져옵니다.
	 *
	 * @return String : 현재 서버 년 문자열로 반환(MMdd)
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
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 8자리 문자열로 반환(yyyyMMdd)
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
	 * time 값의 현재 시간을 가져옵니다.
	 * @param time
	 * @return
	 */
	public static String getCurrentServerTime(long time){
		java.sql.Date date = new java.sql.Date(time);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String temp = dateFormat.format(date);
		return temp;
	}
	
	/**
	 * time 값의 현재 시간을 포멧에 맞추어 가져옵니다.
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getCurrentServerTime(long time, String format){
		java.sql.Date date = new java.sql.Date(time);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(format);
		String temp = dateFormat.format(date);
		return temp;
	}

	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 17자리 문자열로 반환(yyyyMMddHHmmssSSS)
	 */
	public static String getCurrentServerTimeMillis(){
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}
	
	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 14자리 문자열로 반환(yyyyMMddHHmmss)
	 */
	public static String getCurrentServerTimes(){
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}
	
	/**
	 * 현재 서버 시간을 format에 맞추어 가져옵니다.
	 * @param format
	 * @return
	 */
	public static String getCurrentServerTimes(String format){
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat(format);
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}
}
