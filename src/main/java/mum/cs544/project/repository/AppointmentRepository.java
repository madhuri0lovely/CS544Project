package mum.cs544.project.repository;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> fdfcae4a14f8a48cfc7c0fed2a413f1b70ae29d0
import org.springframework.data.repository.CrudRepository;

import mum.cs544.project.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
<<<<<<< HEAD
	public List<Appointment> findByReminder(int reminder);
=======

>>>>>>> fdfcae4a14f8a48cfc7c0fed2a413f1b70ae29d0
}
