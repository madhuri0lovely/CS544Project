package mum.cs544.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mum.cs544.project.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	public List<Appointment> findByReminder(int reminder);
}
