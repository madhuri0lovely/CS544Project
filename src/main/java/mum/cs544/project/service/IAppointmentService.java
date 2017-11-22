package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.entity.Person;

public interface IAppointmentService {
	public boolean createAppointment(Appointment appt);
	public boolean deleteAppointment(long id);
	public List<Appointment> getAppointmentsOfCustomer(Person person);
	public List<Appointment> getAppointmentsByReminder(int reminder);
	public void save(Appointment appointment);
	public Appointment findOne(Long id);
	public List<Appointment> findBySession(Long id);
}
