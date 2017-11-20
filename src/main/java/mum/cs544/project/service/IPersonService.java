package mum.cs544.project.service;

import mum.cs544.project.entity.Person;

public interface IPersonService {
	public Person findByUsername(String username);
}
