package mum.cs544.project.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Location;
import mum.cs544.project.entity.Session;
import mum.cs544.project.repository.LocationRepository;
import mum.cs544.project.repository.SessionRepository;

@Service
public class SessionServiceImpl implements ISessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public boolean createSession(Session session) {
		if(sessionRepository.save(session) != null) return true;
		return false;
	}

	@Override
	public List<Session> getAllSessions() {
		List<Session> sessions = (List<Session>)sessionRepository.findAll();
		return sessions;	
	}
	
	@Override
	public List<Session> getAllFutureSessions() {
		List<Session> sessions = (List<Session>)sessionRepository.findByDateGreaterThan(new Date());
		return sessions;
	}
	
	public Session getSessionById(Long sessionId) {
		return sessionRepository.findOne(sessionId);
	}

	@Override
	public void editSession(Session session, Long id) {
		Session sessionTobeUpdated = sessionRepository.findOne(id);
		sessionTobeUpdated.setCapacity(session.getCapacity());
		sessionTobeUpdated.setCounselor(session.getCounselor());
		sessionTobeUpdated.setDate(session.getDate());
		sessionTobeUpdated.setDuration(session.getDuration());
		sessionTobeUpdated.setLocation(session.getLocation());
		sessionTobeUpdated.setTime(session.getTime());
		
		sessionRepository.save(sessionTobeUpdated);
	}

	@Override
	public void addSession(Session session) {
		sessionRepository.save(session);
	}

	@Override
	public void deleteSession(Long id) {
		sessionRepository.delete(id);
	}




}
