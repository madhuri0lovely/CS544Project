package mum.cs544.project.service;

import java.util.List;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.repository.AppointmentRepository;

@Service
=======
import javax.management.Query;

>>>>>>> 92aeb3a3ef5239627fbd734a49da3bfe2f1f0ca0
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.entity.Person;
import mum.cs544.project.entity.Session;
import mum.cs544.project.repository.AppointmentRepository;
import mum.cs544.project.repository.SessionRepository;

<<<<<<< HEAD
@Service
=======
>>>>>>> fdfcae4a14f8a48cfc7c0fed2a413f1b70ae29d0
>>>>>>> 92aeb3a3ef5239627fbd734a49da3bfe2f1f0ca0
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
<<<<<<< HEAD
	
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
=======
	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public boolean createAppointment(Appointment appt) {
		Session session = appt.getSession();
		session.setCapacity(session.getCapacity() - 1);

		if (appointmentRepository.save(appt) != null || sessionRepository.save(session) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAppointment(Appointment appt) {
		Session session = appt.getSession();
		session.setCapacity(session.getCapacity() + 1);

		appointmentRepository.delete(appt);
		sessionRepository.delete(session);
		return false;
	}
	
	@Override
	public List<Appointment> getAppointmentsOfCustomer(Person person) {
		
		return null;
>>>>>>> fdfcae4a14f8a48cfc7c0fed2a413f1b70ae29d0
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

}
