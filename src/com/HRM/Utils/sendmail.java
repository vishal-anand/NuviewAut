package com.HRM.Utils;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public class sendmail {
	
	

	

		public static void Reporting(){
				
			   final String username = "vishal.anand@ignitetech.com";
			   final String password = "@passw0rd!";

			   Properties props = new Properties();
			   props.put("mail.smtp.auth", true);
			   props.put("mail.smtp.starttls.enable", true);
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");



			   Session session = Session.getInstance(props,
			           new javax.mail.Authenticator() {
			               protected PasswordAuthentication getPasswordAuthentication() {
			                   return new PasswordAuthentication(username, password);
			               }
			           });

			   try {

			       Message message = new MimeMessage(session);
			       message.setFrom(new InternetAddress("vishal.anand@ignitetech.com"));
			       message.setRecipients(Message.RecipientType.TO,
			               InternetAddress.parse("vishal.anand@ignitetech.com , vic14m@gmail.com"));
			       
			       message.setRecipients(Message.RecipientType.CC,
			       		InternetAddress.parse("vishalanand1405@gmail.com"));
			       
			       message.setSubject("Test Automation Report-This is just Testing the mail concept");
			       message.setText("PFA");
			       message.setContent("<h1>This is actual message</h1>", "text/html" );
			       
			       BodyPart messageBodyPart = new MimeBodyPart();
				      messageBodyPart.setText("PFA");

				       Multipart multipart = new MimeMultipart();
				       
				       multipart.addBodyPart(messageBodyPart);
				       
				      messageBodyPart = new MimeBodyPart();
				       String file = "C://Users//Vishal Anand//workspace//Nuview_HRMS//test-output//html//index.html";

				       String fileName = "HTML report";
				       DataSource source = new FileDataSource(file);
				       messageBodyPart.setDataHandler(new DataHandler(source));
				       messageBodyPart.setFileName(fileName);
				       multipart.addBodyPart(messageBodyPart);

				       message.setContent(multipart);


			      /* MimeBodyPart messageBodyPart = new MimeBodyPart();

			       Multipart multipart = new MimeMultipart();

			       multipart.addBodyPart(messageBodyPart);
			       messageBodyPart = new MimeBodyPart();
			       String file = "C://Users//Vishal Anand//workspace//AppiumRoutematicRegression//test-output//emailable-report.html";
			       
			       String fileName = "Test Report";
			       DataSource source = new FileDataSource(file);
			       messageBodyPart.setDataHandler(new DataHandler(source));
			       messageBodyPart.setFileName(fileName);
			       multipart.addBodyPart(messageBodyPart);

			       message.setContent(multipart);*/

			       System.out.println("Sending");

			       Transport.send(message);

			       System.out.println("Done");

			   } catch (MessagingException e) {
			       e.printStackTrace();
			   }
			 }
	}




