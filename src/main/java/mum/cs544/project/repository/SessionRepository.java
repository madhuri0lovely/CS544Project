package mum.cs544.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.cs544.project.entity.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
	List<Session> findByDateGreaterThan(Date date);
	List<Session> findByDateGreaterThanAndCapacityGreaterThan(Date date, int seats);
}
