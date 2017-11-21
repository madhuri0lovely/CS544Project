package mum.cs544.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import mum.cs544.project.entity.Location;
import mum.cs544.project.entity.Person;
import mum.cs544.project.entity.Role;
import mum.cs544.project.service.ILocationService;
import mum.cs544.project.service.IPersonService;
import mum.cs544.project.service.ISessionService;

@Controller
public class SessionController {

	@Autowired
	ISessionService sessionService;

	@Autowired
	IPersonService personService;
	
	@Autowired
	ILocationService locationService;

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public String getAllSessions(Model model) {
		model.addAttribute("sessions", sessionService.getAllSessions());
		return "sessions";
	}

	@RequestMapping(value = "/createSession", method = RequestMethod.GET)
	public String getAllSessions(@Valid Session session) {
		return "createSession";
	}

	@RequestMapping(value = "/sessions", method = RequestMethod.POST)
	public String createSession(@Valid Session session, BindingResult result) {
		String view = "redirect:/sessions";
		if (!result.hasErrors())
			sessionService.createSession(session);
		else
			view = "createSession";

		return view;
	}

	@RequestMapping(value = "/session_edit/{id}", method = RequestMethod.GET)
	public String ediPlayer(@ModelAttribute("sessionForUpdated") Session session, Model model, @PathVariable("id") Long id) {
		Session sessionForUpdated = sessionService.getSessionById(id);
		Map<Long, String> conselors = getListOfConselor();
		Map<Long, String> locations = getListOfLocation();
		Map<Date, String> times = getTimes();

		model.addAttribute("locations", locations);
		model.addAttribute("conselors", conselors);
		model.addAttribute("times", times);
		model.addAttribute("sessionForUpdated", sessionForUpdated);

		return "session_edit";
	}

	@RequestMapping(value = { "/session_edit/{id}" }, method = RequestMethod.POST)
	public String editSession(@Valid @ModelAttribute("sessionForUpdated") Session session, BindingResult bindingresult, Model model, @PathVariable("id") Long id) {
		if (bindingresult.hasErrors()) {
//			Session sessionForUpdated = sessionService.getSessionById(id);
//			Map<Long, String> conselors = getListOfConselor();
//			Map<Long, String> locations = getListOfLocation();
//			Map<Date, String> times = getTimes();
//
//			model.addAttribute("locations", locations);
//			model.addAttribute("conselors", conselors);
//			model.addAttribute("times", times);
//			model.addAttribute("sessionForUpdated", sessionForUpdated);

			return "session_edit";
		}
		
		sessionService.editSession(session,id);
		return "redirect:/sessions";
	}


	private Map<Long, String> getListOfLocation() {
		Map<Long, String> map = new HashMap<>();
		List<Location> locations = locationService.getAllLocation();
		for (Location location : locations) {
			map.put(location.getId(), location.getName());
		}
		return map;
	}

	public Map<Long, String> getListOfConselor() {
		List<Person> conselors = personService.getAllConselor();
		Map<Long, String> conselor_list = new HashMap<>();

		for (Person conselor : conselors) {
			 List<Role> roles = conselor.getRoles();
			 for (Role role : roles) {
				 if (role.getName().equals("CONSELOR"))
					 conselor_list.put(conselor.getId(), conselor.getFullName());
			 }
		}

		return conselor_list;
	}

	private Map<Date, String> getTimes() {
		Date time1 = new Calendar.Builder()
		        .setDate(2016, 1, 1)
		        .setTimeOfDay(12, 0, 0)
		        .setLocale(Locale.UK).build()
		        .getTime();
		Date time2 = new Calendar.Builder()
		        .setDate(2016, 1, 1)
		        .setTimeOfDay(12, 15, 0)
		        .setLocale(Locale.UK).build()
		        .getTime();
		Date time3 = new Calendar.Builder()
		        .setDate(2016, 1, 1)
		        .setTimeOfDay(15, 0, 0)
		        .setLocale(Locale.UK).build()
		        .getTime();
		Date time4 = new Calendar.Builder()
		        .setDate(2016, 1, 1)
		        .setTimeOfDay(15, 30, 0)
		        .setLocale(Locale.UK).build()
		        .getTime();
		
		//Sat Mar 03 00:00:00 CST 2018
		Map<Date, String> times = new HashMap<>();
		times.put(time1, "12:00:00");
		times.put(time2, "12:15:00");
		times.put(time3, "15:00:00");
		times.put(time4, "15:30:00");
		
		return times;
	}
}
