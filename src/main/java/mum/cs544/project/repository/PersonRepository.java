package mum.cs544.project.repository;

import org.springframework.data.repository.CrudRepository;

import mum.cs544.project.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	public Person findByUsername(String username);
}
