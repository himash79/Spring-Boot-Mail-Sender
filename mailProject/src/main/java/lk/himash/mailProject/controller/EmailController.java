package lk.himash.mailProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.himash.mailProject.service.EmailService;

@RestController
@RequestMapping("/emailApi")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/sendEmailWithMailTrap")
	public String sendEmailMailTrap() {
		System.out.println("Start | sendEmailMailTrap() | EmailController");
		try {
			String to = "TO_USSER_EMAIL";
			String from = "FROM_USER_EMAIL";
			String subject = "Regarding Registration";
			String body = "Registration successfully !";
			emailService.sendSimpleMessageMailTrap(to, from, subject, body);
		} catch (Exception ex) {
			System.out.println("Exception found on | sendEmailMailTrap() | EmailController");
			System.out.println(ex.getMessage());
		}
		return "email send successfully";
	}
	
	@GetMapping("/sendEmailWithGmail")
	public String sendEmailGmail() {
		System.out.println("Start | sendEmailGmail() | EmailController");
		try {
			emailService.sendSimpleMessageGmail("TO_USER_EMAIL","This is email body", "This is email subject");
		} catch (Exception ex) {
			System.out.println("Exception found on | sendEmailGmail() | EmailController");
			System.out.println(ex.getMessage());
		}
		return "email send successfully";
	}

}
