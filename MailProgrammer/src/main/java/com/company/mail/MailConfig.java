package com.company.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration  //or @Component
//When we remove @Component from both the class of SmtpMailSender & MockMailSender .Thus, we have to use @Configuration
public class MailConfig {

	//NOTE : any bean can be injected into a bean method just by passing it as a parameter
	
	@Bean
	//@Primary use with @Component or //@Profile("prod") use it with spring.profiles.active in(application.properties)
	@ConditionalOnProperty(name="spring.mail.host" , havingValue="foo" , matchIfMissing=true)
	public MailSender mockMailSender()
	{
		return new MockMailSender() ;
	}
	
	
	@Bean
	//@Primary                  OR             //@Profile("!prod")           OR
	@ConditionalOnProperty("spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSender)
	//here Instead of @Autowired private JavaMailSender javaMailSender;   , we are passing it in parameter constructor 
	{
		return new SmtpMailSender(javaMailSender) ;
	}
}
