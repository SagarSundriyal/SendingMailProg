package com.company.mail;

//commons.logging is actually wrapper around SLF4J And SLF4J , in turn , will be using LogBack by default
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


//This is not going to SEND actual SMTP Mails But this is going to Write the Mail Lines just to the log

//@Component  // Importance of @Component is to CREATE Object(mailSender) in Container
//@Primary //priority will be given to that MockMailSender.class not to SmtpMailSender.class
//@Component("sagarSundriyal")
public class MockMailSender implements MailSender{

	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		// TODO Auto-generated method stub
		log.info("Sending MOCK mail to " +to);
		log.info("with subject " +subject);
		log.info("and body " +body);
	}
}
