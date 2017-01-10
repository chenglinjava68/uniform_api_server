package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

public class FileUtil {
	public static void ToHttpResponse(HttpServletResponse response,String filePath, String downloadFileName) throws Exception{
		File f = new File(filePath);
		if(!f.exists())
			throw new Exception("指定的文件不存在.");
		if(downloadFileName==null || downloadFileName.length()==0)
			downloadFileName = "download.png";
		
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		// 设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
		System.out.println("file length is :"+f.length());
		response.setHeader("Content-Length", "" + f.length());
		response.setHeader("Accept-Ranges", "bytes");
		// 读取目标文件，通过response将目标文件写到客户端
		// 获取目标文件的绝对路径
		// System.out.println(fullFileName);
		// 读取文件
		InputStream in = new FileInputStream(f);
		OutputStream out = response.getOutputStream();
		// 写文件
		int b;
		while ((b = in.read()) != -1)
			out.write(b);
		in.close();
		out.close();
	}
}
