package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Appointment;
import mum.cs544.project.entity.Person;

public interface IAppointmentService {
	public boolean createAppointment(Appointment appt);
	public boolean deleteAppointment(Appointment appt);
	public List<Appointment> getAppointmentsOfCustomer(Person person);
}
