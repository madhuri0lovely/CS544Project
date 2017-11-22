package mum.cs544.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.entity.Person;
import mum.cs544.project.entity.Session;
import mum.cs544.project.repository.AppointmentRepository;
import mum.cs544.project.repository.SessionRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public boolean createAppointment(Appointment appt) {
		if (appointmentRepository.save(appt) != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAppointment(long id) {
		appointmentRepository.delete(id);
		return false;
	}
	
	@Override
	public List<Appointment> getAppointmentsOfCustomer(Person person) {
		return null;
	}

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

	@Override
	public List<Appointment> getAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

}
