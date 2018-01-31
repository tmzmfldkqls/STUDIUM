package com.st.util;

import java.util.Properties;
import java.util.Random;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSend {
	
	 private String tmp_pwd;
	
	 public String getTmp_pwd() {
		return tmp_pwd;
	}

	public void setTmp_pwd(String tmp_pwd) {
		this.tmp_pwd = tmp_pwd;
	}


	public MailSend(String email) throws Exception{
		    
			Random random = new Random();
			char rc[] = new char[8];
			for(int i=0; i<8; i++) {
				rc[i] = (char)(random.nextInt(26)+65);
			}
			String rs = new String(rc);		
			setTmp_pwd(rs);

	        Properties props = new Properties(); 

	        props.setProperty("mail.transport.protocol", "smtp"); 

	        props.setProperty("mail.host", "smtp.gmail.com"); 

	        props.put("mail.smtp.auth", "true"); 

	        props.put("mail.smtp.port", "465"); 

	        props.put("mail.smtp.socketFactory.port", "465"); 

	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 

	        props.put("mail.smtp.socketFactory.fallback", "false"); 

	        props.setProperty("mail.smtp.quitwait", "false"); 

	         

	        Authenticator auth = new Authenticator(){

	            protected PasswordAuthentication getPasswordAuthentication() { 

	                return new PasswordAuthentication("ddubinanabo@gmail.com", "wjdtmdgh1!"); 

	            }

	        };

	    

	        Session session = Session.getDefaultInstance(props,auth);

	         

	        MimeMessage message = new MimeMessage(session); 

	        message.setSender(new InternetAddress("ddubinanabo@gmail.com")); 

	        message.setSubject("STUDIUM에서 보낸 임시비밀번호 입니다!"); 

	 

	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); 

	         

	        Multipart mp = new MimeMultipart();
	        
	        MimeBodyPart mbp1 = new MimeBodyPart();

	        mbp1.setText("임시 비밀번호 : "+getTmp_pwd()+"\n 바로 회원정보 들어가셔서 수정하시길 바랍니다.");

	        mp.addBodyPart(mbp1);
	        
	        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();

	        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");

	        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");

	        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");

	        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");

	        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");

	        CommandMap.setDefaultCommandMap(mc);
	         

	        message.setContent(mp);

	         

	        Transport.send(message);

	    }

}
