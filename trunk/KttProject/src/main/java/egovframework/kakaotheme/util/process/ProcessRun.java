package egovframework.kakaotheme.util.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProcessRun {
	
	protected static final Log log = LogFactory.getLog(ProcessRun.class);
	
	public static void run(String cmdLine) throws Exception{
		ProcessBuilder processBuilder = new ProcessBuilder(cmdLine);
		processBuilder.redirectErrorStream(true);
		Process process = null;
		
		try{
			process = processBuilder.start();
		}catch(Exception e){
			e.printStackTrace();
			process.destroy();
		}
		
		outLogInputStream(process.getInputStream());
		
		try{
			process.waitFor();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(process.exitValue() != 0){
			log.error("변환중 Error 발생");
			throw new Exception();
		}
		
		process.destroy();
	}
	
	public static void run(String[] cmdLine) throws Exception{
		ProcessBuilder processBuilder = new ProcessBuilder(cmdLine);
		processBuilder.redirectErrorStream(true);
		Process process = null;
		try{
			process = processBuilder.start();
		}catch(Exception e){
			e.printStackTrace();
			process.destroy();
		}
		
		outLogInputStream(process.getInputStream());
		
		try{
			process.waitFor();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(process.exitValue() != 0){
			log.error("변환중 Error 발생");
		}
		
		process.destroy();
	}
	
	private static void outLogInputStream(final InputStream is){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(is));
			String cmd = null;
			while((cmd = br.readLine()) != null){
				log.info(cmd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
