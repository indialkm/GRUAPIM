package c_01_AcademiaDev.controller;

import java.util.Optional;

import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.session.UserSession;
import c_01_AcademiaDev.repository.SessionRepository;
import c_01_AcademiaDev.repository.UserRepository;

public class AuthController {
	
	private UserRepository userRepository;
	private SessionRepository sessionRepository;
	
	public AuthController(UserRepository userRepository, SessionRepository sessionRepository) {
		this.userRepository = userRepository;
		this.sessionRepository = sessionRepository;
	}

	public UserSession login(String email, String password) {
	
		return userRepository.findByEmail(email)
		        .filter(user -> user.getPassword().equals(password))
		        .map(user -> {
		            UserSession session = new UserSession(
		                user.getId(),
		                user.getName(),
		                user.getRole()
		            );
		            // Explicar pro prof que não é a forma mais segura, porém é a mais facil
		            sessionRepository.save(String.valueOf(user.getId()), session);
		            return session;
		        })
		        .orElse(null);
	}
	
	public void logout(int userId) {
	    
	    String sessionId = String.valueOf(userId);
	    
	    sessionRepository.delete(sessionId);
	    
	    System.out.println("Sessão do usuário " + userId + " foi encerrada.");
	}
	
	public void adminPage(UserSession session) {
		Optional.ofNullable(session)
		.filter(s -> s.getRole() == Role.ADMIN)
		.ifPresentOrElse(
	            s -> System.out.println("Bem-vindo ao painel: " + s.getName()),
	            () -> System.out.println("Acesso Negado ou Sessão Inválida")
	        );
		
	}
	

}
