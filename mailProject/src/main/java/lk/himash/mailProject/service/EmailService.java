package lk.himash.mailProject.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {
	
	public JavaMailSender getJavaMailSenderMailTrap();
	public void sendSimpleMessageMailTrap(String to, String from, String subject, String text);
	public void sendSimpleMessageGmail(String to, String subject, String text);
	
}
