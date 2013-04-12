package egovframework.kakaotheme.util.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessRun {
	
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
			System.out.println("변환중 Error 발생");
		}
		
		process.destroy();
	}
	
	private static void outLogInputStream(final InputStream is){
		int iTotalFrameSize = 0;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(is));
			String cmd = null;
			while((cmd = br.readLine()) != null){
				if(cmd.indexOf("end") > -1 ){
					String totalFrame = cmd.substring(cmd.indexOf("end")+4, cmd.length());
					String cleanTotalFrame = totalFrame.substring(0, totalFrame.indexOf('.'));
					iTotalFrameSize = Integer.parseInt(cleanTotalFrame);
				}
				
				if(cmd.startsWith("frame")){
					int curConvFrameSize = Integer.parseInt(cmd.substring(6, 11).trim());
					System.out.println(Math.round((float)((float)curConvFrameSize/(float)iTotalFrameSize) * 100)+"%");
				}
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
