		package com.example.vmedico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vmedico.entity.Admin;
import com.example.vmedico.entity.Appointment;
import com.example.vmedico.service.AdminServiceImplementation;
import com.example.vmedico.service.AppointmentServiceImplementation;


@Controller
@RequestMapping("/user")
public class UserController {
	private AppointmentServiceImplementation appointmentServiceImplementation;

	private AdminServiceImplementation adminServiceImplementation;
	
	@Autowired
	public UserController(AppointmentServiceImplementation obj1,AdminServiceImplementation obj ) {
		appointmentServiceImplementation= obj1;
		adminServiceImplementation=obj;
		 
	}
	
	@GetMapping("/index")
	public String index(Model model){
		
		// get last seen
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		  
		  
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		Admin admin = adminServiceImplementation.findByEmail(username);
		 
		
		 Appointment obj=new Appointment();
		 
		 obj.setName(admin.getFirstName()+" "+admin.getLastName());
		 
		 obj.setEmail(admin.getEmail());
			
		 System.out.println(obj);
		 
		 model.addAttribute("app",obj);

		
		return "user/index";
	}
	
	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {
		appointmentServiceImplementation.save(obj);
		return "redirect:/user/index";
	}

	
	
	@RequestMapping("/appointment")
	public String appointment(Model model){
		
		
		// get last seen
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		  
		  
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		         List<Appointment> list=appointmentServiceImplementation.findByEmail(username);
		 		
		
		
		
		// add to the spring model
		model.addAttribute("app", list);
		

		return "user/appointment";

}
	
}
