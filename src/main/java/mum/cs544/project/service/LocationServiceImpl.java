package mum.cs544.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Location;
import mum.cs544.project.repository.LocationRepository;

@Service
public class LocationServiceImpl implements ILocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Location> getAllLocation() {
		return (List<Location>)locationRepository.findAll();
	}

}
