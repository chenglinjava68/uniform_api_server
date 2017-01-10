package util;

import java.io.File;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.intelgoo.qqvisa.po.Systemset;
import com.intelgoo.qqvisa.service.SystemsetService;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class EmailUtil {

/*"password": "YPinchina123",
  "smtp": "smtp.qq.com",
  "port": 25,
  "auth": "true",
  "timeout": "3600",
  "username": "dengshunping@intelgoo.com"*/
	public static class EmailSettingClass
	{
		private String password = "";
		private String smtp = "";
		private Integer port = 25;
		private String auth = "true";
		private String timeout = "3600";
		private String username = "";
		public String getPassword() { return this.password; }
		public void setPassword(String val){ this.password = val; }
		public String getSmtp() { return this.smtp; }
		public void setSmtp(String val){ this.smtp = val; }
		public Integer getPort() { return this.port; }
		public void setPosrt(Integer port){ this.port = port; }
		public String getAuth() { return auth; }
		public void setAuth(String val){ auth = val; }
		public String getTimeout() { return timeout; }
		public void setTimeout(String val){ timeout = val; }
		public String getUsername() { return this.username; }
		public void setUsername(String val){ username = val; }

	};
	protected static JavaMailSenderImpl createSender(Systemset config)
	{
		 EmailSettingClass es = JSON.toJavaObject(JSON.parseObject(config.getStringValue()), EmailSettingClass.class);

         JavaMailSenderImpl sender = new JavaMailSenderImpl();
		 sender.setHost(es.getSmtp());
		 sender.setPort(es.getPort());
         Properties prop = new Properties();
         prop.setProperty("mail.smtp.auth", es.getAuth());
         prop.setProperty("mail.smtp.timeout", es.getTimeout());
		 sender.setJavaMailProperties(prop);
		 sender.setUsername(es.getUsername());
		 sender.setPassword(es.getPassword());
		 return sender;
	}
	public static boolean sendMail(
			Systemset config,
			String[] to, // 主送地址
			String[] cc, // 抄送地址
			String[] bcc, // 密送地址
			String subject, // 标题
			String content, // 内容
			String attachment, // 附件
			boolean isHtml // 内容为html
	) {

		try {
			JavaMailSenderImpl sender = EmailUtil.createSender(config);

			String from = sender.getUsername();
				
			MimeMessage mm = sender.createMimeMessage();

			MimeMessageHelper helper = null;
			if (isHtml) {
				helper = new MimeMessageHelper(mm, true, "UTF-8");
			} else {
				helper = new MimeMessageHelper(mm, true);
			}
			helper.setFrom(from);
			helper.setTo(to);

			if (cc != null && cc.length > 0) {
				helper.setCc(cc);
			}
			if (bcc != null && bcc.length > 0) {
				helper.setBcc(bcc);
			}

			helper.setSubject(subject);
			if (isHtml) {
				helper.setText(content, true);
			} else {
				helper.setText(content);
			}
			if (StringUtils.hasText(attachment)) {
				File file = new File(attachment);
				if (file.exists()) {
					FileSystemResource fileAttachment = new FileSystemResource(file);
					helper.addAttachment(fileAttachment.getFilename(), fileAttachment);
				}
			}
			sender.send(mm);
		} catch (MessagingException e) {
			return false;
		}
		return true;
	}
}