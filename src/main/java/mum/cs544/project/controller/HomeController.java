package mum.cs544.project.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.project.model.User;
import mum.cs544.project.service.JMSService;

@Controller
public class HomeController {
	
	@Autowired
	private JMSService jmsSender;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(@ModelAttribute("user") User user) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		System.out.println("===["+bCrypt.encode("admin")+"]");
		
		jmsSender.sendJMSMessage("ETHER|0|1");
		
		return "home";
	}
	
	@RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String afterLogin(Model model) {
		System.out.println("welcome.....");
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			switch(grantedAuthority.getAuthority()) {
			case "ROLE_ADMIN":
				return "redirect:/admin/adminPage";
			case "ROLE_COUNSELOR":
				return "redirect:/faculty/facultyPage";
			case "ROLE_CUSTOMER":
				return "redirect:/staff/findStudent";
			}
		}  
        return "home";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("user") User user, Model model, String error, String logout) {
		System.out.println("login get..............error["+error+"], logout["+logout+"]");
		if (error != null)
            model.addAttribute("errorMsg", "Your username and password is invalid.");

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
            return "home";
        }
        
        return "login";
    }
}
