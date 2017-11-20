package mum.cs544.project.repository;

import org.springframework.data.repository.CrudRepository;

import mum.cs544.project.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
