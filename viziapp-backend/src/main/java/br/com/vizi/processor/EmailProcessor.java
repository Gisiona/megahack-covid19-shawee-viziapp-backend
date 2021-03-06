package br.com.vizi.processor;

import java.io.IOException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.xml.fastinfoset.sax.Properties;

public class EmailProcessor {

	protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("contato@viziapp.com.br", "viziapp");
    }
	
	private void sendMail() throws AddressException, MessagingException, IOException {
		
		// TODO
		Properties props = new Properties();
		//props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.host", "smtp.gmail.com");
		//props.put("mail.smtp.port", "587");
	   
		/*
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("contato@viziapp.com.br", "viziapp");
		    }
		});
		*/
		Session session = null;
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));
	
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tutorialspoint@gmail.com"));
		msg.setSubject("Tutorials point email");
		msg.setContent("Tutorials point email", "text/html");
		msg.setSentDate(new Date());
	
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Tutorials point email", "text/html");
	
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
	
		attachPart.attachFile("/var/tmp/image19.png");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);   
	}
}
