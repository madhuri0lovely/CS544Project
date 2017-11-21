package mum.cs544.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Person;
import mum.cs544.project.repository.PersonRepository;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public Person findByUsername(String username) {
		return personRepository.findByUsername(username);
	}

	@Override
	public List<Person> getAllConselor() {
		List<Person> conselors = (List<Person>) personRepository.findAll(); // it should be just conselor
		return conselors;
	}

}
