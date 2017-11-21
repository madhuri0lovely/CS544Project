package mum.cs544.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	public List<Appointment> findByReminder(int reminder);
}
