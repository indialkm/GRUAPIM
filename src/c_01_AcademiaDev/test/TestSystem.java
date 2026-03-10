package c_01_AcademiaDev.test;

import java.util.List;

import c_01_AcademiaDev.controller.*;
import c_01_AcademiaDev.model.User;
import c_01_AcademiaDev.model.enums.*;
import c_01_AcademiaDev.model.session.UserSession;
import c_01_AcademiaDev.repository.*;
import c_01_AcademiaDev.security.SecurityService;


public class TestSystem {
    
	public static void main(String[] args) {
		
		// 1. INICIALIZAÇÃO DA INFRAESTRUTURA
        UserRepository userRepo = new UserRepository();
        SessionRepository sessionRepo = new SessionRepository();
        LessonRepository lessonRepo = new LessonRepository();
        EnrollmentsRepository enrollRepo = new EnrollmentsRepository();
        SuportTicketsRepository supportRepo = new SuportTicketsRepository();
        SecurityService securityService = new SecurityService();
        
        LessonController lessonController = new LessonController(lessonRepo);
        CourseRepository courseRepo = new CourseRepository(lessonController, lessonRepo);
        
        UserController userController = new UserController(userRepo);
        AuthController authController = new AuthController(userRepo, sessionRepo);
        ExportService exportService = new ExportService();

        System.out.println("========== INICIANDO BATERIA DE TESTES COMPLETOS ==========\n");

        // 2. CADASTRO E LOGIN (O ponto de partida)
        userController.save("Catarina", "catarina@email.com", SubscriptionPlans.BASIC, "123", Role.STUDENT);
        userController.save("Admin Master", "admin@email.com", SubscriptionPlans.PLATINUM, "admin123", Role.ADMIN);

        UserSession sessaoCatarina = authController.login("catarina@email.com", "123");
        UserSession sessaoAdmin = authController.login("admin@email.com", "admin123");

        // 3. GERENCIAMENTO DE CURSOS (Admin vs Student)
        CourseController courseControllerAdmin = new CourseController(sessaoAdmin, securityService, courseRepo, lessonController, lessonRepo);
        
        System.out.println("--- Teste 1: Cadastro de Cursos por Admin ---");
        courseControllerAdmin.register("Java Avançado", "Spring Boot", "Nélio Alves", DifficultyLevel.ADVANCED, StatusCourse.ACTIVE); // ID 1
        courseControllerAdmin.register("Lógica de Programação", "Base", "Guanabara", DifficultyLevel.BEGINNER, StatusCourse.ACTIVE); // ID 2
        
        // 4. TESTE DE PROGRESSO REAL (O ciclo que você queria ver)
        System.out.println("\n--- Teste 2: Ciclo de Vida da Aula e Progresso ---");
        
        // Admin adiciona 2 aulas ao curso de ID 1 (Java Avançado)
        courseControllerAdmin.registerLesson("Introdução ao Reflection", 1);
        courseControllerAdmin.registerLesson("Manipulando Atributos", 1);
        
        System.out.println("Aulas criadas para o curso ID 1.");

        // Catarina conclui a primeira aula (ID 1)
        lessonController.progressCourse(1); 
        System.out.println("Catarina concluiu a aula ID 1.");

        // Atualizamos o progresso do curso de ID 1
        double progresso = courseControllerAdmin.registerProgress(1);
        System.out.printf("Progresso calculado para o curso ID 1: %.2f%%\n", progresso * 100);

        // 5. RELATÓRIOS ANALÍTICOS (Usando os dados que criamos)
        System.out.println("\n--- Teste 3: Relatórios e Análises ---");
        
        // Simular matrícula para o relatório de plano e média funcionar
        User catarinaUser = userRepo.findbyId(sessaoCatarina.getUserId()).get();
        enrollRepo.save(catarinaUser, courseRepo.findById(1).get());

        System.out.println("Média Geral de Progresso da Plataforma:");
        System.out.printf("%.2f%%\n", exportService.mediaProgressoGeral(enrollRepo.listAll()) * 100);

        System.out.println("\nInstrutores Únicos:");
        exportService.instrutoresUnicos(courseRepo.listAll()).forEach(i -> System.out.println(" - " + i));

        // 6. EXPORTAÇÃO CSV DINÂMICA (O Gran Finale)
        System.out.println("\n--- Teste 4: Exportação CSV Dinâmica (Reflection) ---");
        
        System.out.println("CSV DE CURSOS (Campos: title, instructorName, progress):");
        List<String> colunas = List.of("title", "instructorName", "progress");
        System.out.println(exportService.exportarParaCSV(courseRepo.listAll(), colunas));

        System.out.println("========== FIM DOS TESTES ==========");

        
    }
    }
