package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Person;

public interface IPersonService {
	public Person findByUsername(String username);
	public List<Person> getAllConselor();
}
