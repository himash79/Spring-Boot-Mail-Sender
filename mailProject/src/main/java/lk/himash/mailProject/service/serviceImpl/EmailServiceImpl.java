package lk.himash.mailProject.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import lk.himash.mailProject.service.EmailService;
import lk.himash.mailProject.util.EmailData;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public JavaMailSender getJavaMailSenderMailTrap() {
		System.out.println("Start | getJavaMailSenderMailTrap() | EmailServiceImpl");
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		EmailData emailData = new EmailData();
		try {
			mailSenderImpl.setHost(emailData.MAIL_HOST_MAILTAP);
			mailSenderImpl.setPort(emailData.MAIL_PORT_MAILTAP);
			mailSenderImpl.setUsername(emailData.MAIL_USERNAME_MAILTAP);
			mailSenderImpl.setPassword(emailData.MAIL_PASSWORD_MAILTAP);
		} catch (Exception ex) {
			System.out.println("Exception found on | getJavaMailSenderMailTrap() | EmailServiceImpl");
			System.out.println(ex.getMessage());
		}
		return mailSenderImpl;
	}

	@Override
	public void sendSimpleMessageMailTrap(String to, String from, String subject, String text) {
		System.out.println("Start | sendSimpleMessageMailTrap() | EmailServiceImpl");
		SimpleMailMessage message = new SimpleMailMessage();
		try {
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			message.setFrom(from);
			getJavaMailSenderMailTrap().send(message);
		} catch (Exception ex) {
			System.out.println("Exception found on | sendSimpleMessageMailTrap() | EmailServiceImpl");
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void sendSimpleMessageGmail(String toEmail, String subject, String body) {
		System.out.println("Start | sendSimpleMessageGmail() | EmailServiceImpl");
		SimpleMailMessage message = new SimpleMailMessage();
		System.out.println(toEmail + " | " + subject + " | " + body);
		try {
			message.setFrom("FROM_USER_EMAIL");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			mailSender.send(message);
		} catch (Exception ex) {
			System.out.println("Exception found on | sendSimpleMessageGmail() | EmailServiceImpl");
			System.out.println(ex.getMessage());
		}
	}

}
