package mum.cs544.project.service;

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

}
