package c_01_AcademiaDev.repository;
import java.util.HashMap;
import java.util.Map;

import c_01_AcademiaDev.model.session.UserSession;

public class SessionRepository {
	
	private Map<String,UserSession> sessions = new HashMap<>();
	
	public void save(String sessionId, UserSession session) {
		sessions.put(sessionId, session);
	}
	
	public void delete(String sessionId) {
		sessions.remove(sessionId);
	}
	
	public UserSession findById(String sessionId) {
		return sessions.get(sessionId);
	}

}
