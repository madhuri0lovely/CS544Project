package mum.cs544.project.service;

import java.util.List;

import mum.cs544.project.entity.Session;

public interface ISessionService {
	public boolean createSession(Session session);
	public List<Session> getAllSessions();
}
