package egovframework.kakaotheme.util.string;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringGenerator {
	
	protected static final Log log = LogFactory.getLog(StringGenerator.class);
	
	/**
	 * 특정 위치에서 특정 위치까지의 UNICODE값을 통하여 문자열을 리턴합니다. 
	 * @param startIndex
	 * @param lastIndex
	 * @param sizeWeight
	 * @return
	 */
	public static String getUniCode(int startIndex, int lastIndex, int sizeWeight){
		int length = (int) (Math.random() * sizeWeight) + 1;
		char[] charSequence = new char[length];  
		
		for (int i = 0; i < length; i++){  
			int randomInt = startIndex + (int)(Math.random() * ((lastIndex - startIndex) + 1));  
			charSequence[i] = (char)randomInt;  
		}
		
		String result = new String(charSequence);
		log.info("generator Unicode : " + result);
		
		return result;
	}
	
	public static String getUniCode(int startIndex, int lastIndex, int sizeWeight, int lineCnt){
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < lineCnt; i++){
		   int length = (int) (Math.random() * sizeWeight) + 1;
	       char[] charSequence = new char[length];
	       
      	   for (int j = 0; j < length; j++){  
      	      int randomInt = startIndex + (int)(Math.random() * ((lastIndex - startIndex) + 1));  
      	      charSequence[j] = (char)randomInt;  
      	   }
      	   sb.append(new String(charSequence) + "\n");
		}
		log.info("generator Unicode : " + sb.toString());
		return sb.toString();
	}
	
	
}
