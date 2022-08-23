package lk.himash.mailProject.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {
	
	public JavaMailSender getJavaMailSender();
	
	public void sendSimpleMessage(String to, String from, String subject, String text);

}
