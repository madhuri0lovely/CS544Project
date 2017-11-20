package mum.cs544.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.project.entity.Session;
import mum.cs544.project.service.ISessionService;

@Controller
public class SessionController {
	
	@Autowired
	ISessionService sessionService;
	
	@RequestMapping(value="/sessions", method=RequestMethod.GET)
	public String getAllSessions(Model model) {
		model.addAttribute("sessions", sessionService.getAllSessions());
		return "sessions";
	}
	
	@RequestMapping(value="/createSession", method=RequestMethod.GET)
	public String getAllSessions(@Valid Session session) {
		return "createSession";
	}
	
	@RequestMapping(value="/sessions", method=RequestMethod.POST)
	public String createSession(@Valid Session session, BindingResult result) {
		String view = "redirect:/sessions";
		if(!result.hasErrors()) {
			sessionService.createSession(session);
		}
		else {
			view = "createSession";
		}
		return view;
	}
	
	
	@RequestMapping(value = "/session_edit/{id}", method = RequestMethod.GET)
	public String ediPlayer(@ModelAttribute("sessionForUpdated") Session session, Model model, @PathVariable("id") Long id) {
		
		Session sessionForUpdated = sessionService.getSessionById(id);
		model.addAttribute("sessionForUpdated", sessionForUpdated);
		
		return "session_edit";
	}
}
