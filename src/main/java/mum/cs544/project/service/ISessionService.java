package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Location;
import mum.cs544.project.entity.Session;

public interface ISessionService {
	public boolean createSession(Session session);
	public List<Session> getAllSessions();
	public Session getSessionById(Long sessionId);
	public void editSession(Session session, Long id);
	public void addSession(Session session);
	public void deleteSession(Long id);
	public List<Session> getAllFutureSessions();
}
