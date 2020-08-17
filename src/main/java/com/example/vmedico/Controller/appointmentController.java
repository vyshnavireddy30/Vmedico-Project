package com.example.vmedico.Controller;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.vmedico.entity.User;
@Controller
public class appointmentController {
	
	
	// Return registration form template
	@RequestMapping(value="/user", method = RequestMethod.GET)

	public void showRegistrationPage(ModelAndView modelAndView, User user){
		modelAndView.addObject("user", user);
			
		    
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					 + "/confirm?token=");
			registrationEmail.setFrom("spring.email.auth@gmail.com");
			
			
	
	
	
	
		}
}
