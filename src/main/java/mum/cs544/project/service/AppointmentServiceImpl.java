package mum.cs544.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Override
	public List<Appointment> getAppointmentsByReminder(int reminder) {
		return appointmentRepository.findByReminder(reminder);
	}

	@Override
	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public Appointment findOne(Long id) {
		return appointmentRepository.findOne(id);
	}

}
