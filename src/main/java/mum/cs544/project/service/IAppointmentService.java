package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Appointment;

public interface IAppointmentService {
	public List<Appointment> getAppointmentsByReminder(int reminder);
	public void save(Appointment appointment);
	public Appointment findOne(Long id);
}
