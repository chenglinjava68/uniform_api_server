package util;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class StreamUtil {
	public static void ToHttpResponse(HttpServletResponse response,String textData) throws Exception{
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		OutputStream out = response.getOutputStream();
		QRCode.from(textData).to(ImageType.JPG).writeTo(out);
		out.close();
	}
}
