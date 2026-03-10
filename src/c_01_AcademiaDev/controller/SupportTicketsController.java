package c_01_AcademiaDev.controller;

import c_01_AcademiaDev.model.session.UserSession;
import c_01_AcademiaDev.repository.SuportTicketsRepository;
import c_01_AcademiaDev.repository.UserRepository;
import c_01_AcademiaDev.security.SecurityService;

public class SupportTicketsController {
	
	private SuportTicketsRepository supportRepository;
    private UserRepository userRepository;
    private SecurityService security;
    private UserSession session;

    public SupportTicketsController(UserSession session, SecurityService security, SuportTicketsRepository supportRepository, UserRepository userRepository) {
        this.session = session;
        this.security = security;
        this.supportRepository = supportRepository;
        this.userRepository = userRepository;
    }

    // 1. ALUNO ABRE O TICKET
    public void createTicket(String title, String message) {
       
        userRepository.findbyId(session.getUserId()).ifPresentOrElse(
            user -> {
                supportRepository.abrirTicket(user, title, message);
            },
            () -> System.out.println("Erro: Usuário da sessão não encontrado no banco.")
        );
    }

    
    public void answerNextTicket() {
      
        if (security.isAdmin(session)) {
            System.out.println("Verificando fila de suporte...");
            supportRepository.atenderProximo();
        } else {
            System.out.println("ACESSO NEGADO: Apenas administradores podem processar tickets de suporte.");
        }
    }

}
