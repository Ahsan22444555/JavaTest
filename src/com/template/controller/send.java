package com.template.controller;

import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send {
	public static void sendEmail(
            final String userName, final String password, String Address,
            String subject, String message) throws AddressException,
            MessagingException {
		
		System.out.println(userName+password+Address+subject+message);
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message mesg = new MimeMessage(session);
 
        mesg.setFrom(new InternetAddress(userName));
//        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        mesg.setRecipient(Message.RecipientType.TO, new InternetAddress(Address));
        mesg.setSubject(subject);
        mesg.setText(message);
 
        // sends the e-mail
        Transport.send(mesg);
 
    }
}
