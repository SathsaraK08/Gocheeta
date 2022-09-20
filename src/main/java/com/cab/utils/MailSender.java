
package com.cab.utils;
import java.util.*;  
import javax.activation.*;  
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    
    public static boolean sendMail(String Tomail, String Content, String Subject )
    {
         // Recipient's email ID needs to be mentioned.
        String to = Tomail;

        // Sender's email ID needs to be mentioned
        String from = "email";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("email", "pasword");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(Subject);

            // Now set the actual message
            message.setContent(Content,"text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        } 
   } 
    
    
    public static boolean sendMailTextContent(String Tomail, String Content, String Subject )
    {
         // Recipient's email ID needs to be mentioned.
        String to = Tomail;

        // Sender's email ID needs to be mentioned
        String from = "email";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("email", "password");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(Subject);

            // Now set the actual message
            message.setText(Content);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        } 
   }
    
}

