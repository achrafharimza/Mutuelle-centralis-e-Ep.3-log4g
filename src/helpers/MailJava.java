package helpers;



import java.io.IOException;
import java.util.Properties;

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

import com.mysql.cj.xdevapi.PreparableStatement;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


public class MailJava {
	

	public static void SendMail(String recipient) throws MessagingException  {
		
		System.out.println("methode SendMail");
		
		Properties properties = new Properties();
		
		// Setup mail server
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
		
        String myEmail = "achrafharimza14@gmail.com";
        String mypassword = "efzhxizppyzynaer";
        
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties,new Authenticator() {

        	 @Override
             protected PasswordAuthentication getPasswordAuthentication(){
                 return  new PasswordAuthentication(myEmail,mypassword);
             }

        });
		
		
        Message message = prepareMessage(session,myEmail,recipient);
        Transport.send(message);
        System.out.println("Sent message successfully....");
	}
	
	
	private static Message prepareMessage(Session session, String myEmail, String recipient) {
		System.out.println("Message Message");
		   try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(myEmail));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

	            // Set Subject: header field
	            message.setSubject("ACHRAF APP - New Account");

	            // Now set the actual message
	            message.setText("Compte est bien Cr��");

	            System.out.println("sending...");
	            
	            return  message;
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	            
	        }

		
		return null;
	}
	
	
	
	

	
	/////////////////////////////////////////
	
//	public static void SendMail(String recipient) throws Exception {
//		//authentication info
//		final String username = "achrafharimza14@gmail.com";
//		final String password = "efzhxizppyzynaer";
//		String fromEmail = "achrafharimza14@gmail.com";
//		String toEmail = "achrafharimza77@gmail.com";
//		
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//		
//		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username,password);
//			}
//		});
//		//Start our mail message
//		MimeMessage msg = new MimeMessage(session);
//		try {
//			msg.setFrom(new InternetAddress(fromEmail));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			msg.setSubject("Subject Line");
//			msg.setText("Email body Line");
//			
//			Transport.send(msg);
//			System.out.println("Sent message");
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} 
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	















	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
