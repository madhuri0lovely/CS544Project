package mum.cs544.project.controller;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.entity.Person;
import mum.cs544.project.entity.Session;
import mum.cs544.project.service.IAppointmentService;
import mum.cs544.project.service.IPersonService;
import mum.cs544.project.service.ISessionService;

@Controller
public class AppointmentController {	
	@Autowired
	ISessionService sessionService;
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	IPersonService personService;
	
	@RequestMapping(value="/appointment/create", method=RequestMethod.GET)
	public String getAllSessions(Model model) {
		model.addAttribute("sessions", sessionService.getAllSessions());
		return "createappointment";
	}
	
	@RequestMapping(value="/appointment/list", method=RequestMethod.GET)
	public String getAllAppointments(Model model) {
		//String username=model.
		model.addAttribute("appointments", personService.findByUsername("").getAppointments());//flash attribute
		return "listappointment";
	}
	
	@RequestMapping(value="/appointment/create", method=RequestMethod.POST)
	public String createAppointment(long sessionid, String username, BindingResult result) {
		String view = "redirect:/appointment/list";
		if(!result.hasErrors()) {
			Session session = sessionService.getSessionById(sessionid);
			Person person = personService.findByUsername(username);
			Appointment appt = new Appointment(session, person, new Date());
			appointmentService.createAppointment(appt);
		}
		else {
			view = "/appointment/create";
		}
		return view;
	}
}
