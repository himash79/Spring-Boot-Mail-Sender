package lk.himash.mailProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.himash.mailProject.service.EmailService;

@RestController
@RequestMapping("emailApi")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/sendEmail")
	public String sendEmail() {
//		String to = accountRegistrationForm.getEmail();
		String to = "himashbandara79@gmail.com";
		String from = "OnlineBookstore.com <auto-confirm@onlinebookstore.com>";
		String subject = "Test subject";
		String body = "this is test mail";
//		String subject = accountRegistrationForm.getFirstName() + ", welcome to OnlineBookstore!";
//		String body = accountRegistrationForm.getFirstName() + ", welcome to OnlineBookstore!\r\n" + "\r\n"
//				+ "Browse your favorite books, our editorial picks, bestsellers, or customer favorites.\r\n" + "\r\n";
		emailService.sendSimpleMessage(to, from, subject, body);
		return "email send successfully";
	}
	
}
