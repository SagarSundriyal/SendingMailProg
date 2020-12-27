package com.company.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


//This is not going to SEND actual SMTP Mails But this is going to Write the Mail Lines just to the log
//@Component         //("sagar")
//@Primary
public class SmtpMailSender implements MailSender{  

	
	//JavaMailSender can be used only by adding spring-boot-starter-mail in POM.XML file -- Aim to send Mail
	private JavaMailSender javaMailSender ;
	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	@Override
	public void send(String to, String subject, String body) throws MessagingException{
		// TODO Auto-generated method stub
		//log.info("Sending SMTP mail to " + to + "with subject " + subject + "and body " +body);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper ;
		helper = new MimeMessageHelper(message , true); 
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body , true);    //"TRUE" indicates that we are trying to Set HTML Body 
		
		
		javaMailSender.send(message);
	}
}
