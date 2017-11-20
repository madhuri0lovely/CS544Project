package mum.cs544.project.service;

import mum.cs544.project.entity.Appointment;

public interface IAppointmentService {
	public boolean createAppointment(Appointment appt);
	public boolean deleteAppointment(Appointment appt);
}
