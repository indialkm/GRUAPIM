package c_01_AcademiaDev.security;

import java.util.Optional;

import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.session.UserSession;

public class SecurityService {
	
	public boolean isAdmin(UserSession session) {
	    return Optional.ofNullable(session)
	        .filter(s -> s.getRole() == Role.ADMIN)
	        .isPresent();
	}
	
	public static void validateIsLoggedIn(UserSession session) {
        if (session == null) {
            throw new SecurityException("Acesso negado: Usuário não autenticado.");
        }
    }

}
