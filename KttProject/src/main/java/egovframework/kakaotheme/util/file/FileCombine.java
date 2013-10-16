package egovframework.kakaotheme.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class FileCombine {
   
   static final int BUFFER_SIZE = 1024;
   
   static final char FILE_SEPARATOR = File.separatorChar;
   
   /**
    * org.apache.commons.compress.archivers.zip.ZipFile을 extractDir안에 압축을 푼다.
    * @param archive
    * @param extractDir
    * @throws Exception
    */
   public static void unZip(ZipFile archive, String extractDir) throws Exception {
	   String fileName;
	   String destFileName;
	   byte[] buffer = new byte[BUFFER_SIZE];
	   extractDir = extractDir + File.separator;
	   try {
		   for (Enumeration e = archive.getEntries(); e.hasMoreElements();) {
			   ZipArchiveEntry entry = (ZipArchiveEntry) e.nextElement();
			   if(!entry.isDirectory()) {
				   fileName = entry.getName();
				   fileName = fileName.replace('/', File.separatorChar);
				   destFileName = extractDir + fileName;
				   File destFile = new File(destFileName);
				   String parent = destFile.getParent();
				   if(parent != null) {
					   File parentFile = new File(parent);
					   if(!parentFile.exists())
						   parentFile.mkdirs();
				   }
				   InputStream in = new BufferedInputStream(archive.getInputStream(entry), BUFFER_SIZE);
				   OutputStream out = new BufferedOutputStream(new FileOutputStream(destFileName), BUFFER_SIZE);
               
				   int count;
				   while ((count = in.read(buffer)) != -1) {
					   out.write(buffer, 0, count);
				   }
				   in.close();
				   out.close();
			   } else {
				   File newdir = new File(extractDir + entry.getName());
				   newdir.mkdirs();
			   }
		   }
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
   	}
}
