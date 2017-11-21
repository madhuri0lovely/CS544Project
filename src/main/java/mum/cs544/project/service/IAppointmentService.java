package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Appointment;
<<<<<<< HEAD

public interface IAppointmentService {
	public List<Appointment> getAppointmentsByReminder(int reminder);
	public void save(Appointment appointment);
	public Appointment findOne(Long id);
=======
import mum.cs544.project.entity.Person;

public interface IAppointmentService {
	public boolean createAppointment(Appointment appt);
	public boolean deleteAppointment(Appointment appt);
	public List<Appointment> getAppointmentsOfCustomer(Person person);
>>>>>>> fdfcae4a14f8a48cfc7c0fed2a413f1b70ae29d0
}
