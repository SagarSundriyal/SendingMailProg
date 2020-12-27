package com.company.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.mail.MailSender;

@RestController
public class MailController {
	
	 // /*
	@Autowired
	private MailSender mailSender ; //= new MockMailSender(); //use it when we don't have @Component & @Autowired
	
	public void setMailSender(MailSender moon) {
		this.mailSender = moon;
	}
	//*/
	
	/*//METHOD 2 -   //@Autowired
private MailSender mailSender ;  
@Autowired   //NOTE : In BEAN we will get class name in a camel Case(i.e, first letter of class name as a small letter) 
	public void setMailSender(MailSender mockMailSenderender) {
		this.mailSender = mockMailSenderender;
	}*/
	
/* private MailSender mailSender ; 
	@Autowired
		public void setMailSender(MailSender sagarSundriyal) {
			this.mailSender = sagarSundriyal;
		}*/
	
	@RequestMapping("/mail")
	public String mail() throws MessagingException{
		
		mailSender.send(" jam9inu@gmail.com" , " Test Mail Sent by MailProgrammer.java not by manually" , " Body of the Mail");
		
		return "Mail Sent";
	}

}
