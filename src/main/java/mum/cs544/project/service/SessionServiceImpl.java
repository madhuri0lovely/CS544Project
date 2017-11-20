package mum.cs544.project.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs544.project.entity.Session;
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
		return (List<Session>)sessionRepository.findAll();
	}

}
