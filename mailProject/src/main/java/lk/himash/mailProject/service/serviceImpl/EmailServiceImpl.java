package lk.himash.mailProject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import lk.himash.mailProject.config.EmailConfiguration;
import lk.himash.mailProject.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailConfiguration emailConfig;

	@Override
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(emailConfig.getHost());
		mailSenderImpl.setPort(emailConfig.getPort());
		mailSenderImpl.setUsername(emailConfig.getUsername());
		mailSenderImpl.setPassword(emailConfig.getPassword());
		return mailSenderImpl;
	}

	@Override
	public void sendSimpleMessage(String to, String from, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		message.setFrom(from);
		getJavaMailSender().send(message);
	}

}
