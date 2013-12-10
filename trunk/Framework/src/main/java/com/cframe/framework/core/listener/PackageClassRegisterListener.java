package com.cframe.framework.core.listener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import com.cframe.framework.core.util.ObjectUtil;

public class PackageClassRegisterListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		String packagePath = servletContext.getInitParameter("packagePath");
		String packageLoaderJNDI = servletContext.getInitParameter("packageLoaderJNDI");
		String packageLoaderStart = servletContext.getInitParameter("packageLoaderStart");
		
		if(!packageLoaderStart.equals("false")){
			return;
		}
		
		try {
			InitialContext context = new InitialContext();
			DataSource datasource = (DataSource) context.lookup(packageLoaderJNDI);  
			subDirList(packagePath, "/hycho/work/my/Framework/src/main/java/");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}        
	  
	}
	
	private void setRegistPackageClass(DataSource datasource, String dirPath){
		
	}
	
	private static void subDirList(String dirPath, String replaceName) throws ClassNotFoundException, Exception{
		int fixLength = replaceName.length();
		File dir = new File(dirPath); 
		File[] fileList = dir.listFiles(); 
		try{
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i]; 
				String fileName = file.getName();
				if(file.isFile()){
					if(fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()).equals("java")){
						String packPath = dirPath.replaceAll("/", ".");
						packPath = packPath.substring(fixLength, packPath.length());
						String className = packPath+"."+fileName.substring(0, fileName.lastIndexOf("."));
						System.out.println("\t 파일 이름 = " + dirPath+"/"+file.getName());
						System.out.println(packPath);
						System.out.println(className);
						Method[] methods = ObjectUtil.loadClass(className).getMethods();
						for (int j = 0; j < methods.length; j++) {
							System.out.println(methods[j].isAnnotationPresent(org.springframework.web.bind.annotation.RequestMapping.class));
						}
					}
				}else if(file.isDirectory()){
					subDirList(file.getCanonicalPath().toString(), replaceName); 
				}
			}
		}catch(IOException e){
			
		}
	}

}
