package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.List;

import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.Enrollments;
import c_01_AcademiaDev.model.User;
import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.enums.StatusCourse;
import c_01_AcademiaDev.model.enums.SubscriptionPlans;

public class EnrollmentsRepository {
	
	private List<Enrollments> enrollments = new ArrayList<>();
	private int nextId = 1;
	
	public void save(User user, Course course) {
        // Regra 1: Admin não estuda (pelo menos não aqui rs)
        if(user.getRole() == Role.ADMIN) {
            System.out.println("ERRO: Administradores não podem se matricular.");
            return;
        }

        // Regra 2: Curso deve estar ativo
        if(course.getStatus() != StatusCourse.ACTIVE) {
            System.out.println("ERRO: Curso inativo.");
            return;
        }

        // Regra 3: Validação por Plano
        if(user.getSub() == SubscriptionPlans.BASIC) {
            if(podeMatricularBasic(user)) {
                efetivar(user, course);
            } else {
                System.out.println("BLOQUEIO: Limite de 3 cursos ativos para plano BASIC.");
            }
        } else {
            // Se for PLATINUM, entra direto
            efetivar(user, course);
        }
    }

    private void efetivar(User user, Course course) {
        Enrollments enr = new Enrollments(nextId++, course, user);
        enrollments.add(enr);
        System.out.println("SUCESSO: " + user.getName() + " matriculado em " + course.getTitle());
    }

    // A lógica mágica que você queria: só conta se o curso NÃO estiver 100%
    public boolean podeMatricularBasic(User user) {
        long ativos = enrollments.stream()
            .filter(e -> e.getStudent().getId() == user.getId()) // Filtra por esse aluno
            .filter(e -> e.getCourse().getProgress() < 1.0) // Filtra cursos não finalizados
            .count();
        
        return ativos < 3;
    }
			
		
	
	
	public int gerationId(int id) {
		if(id == 0) {
		return nextId++;
		}
		return 0;
	}
	
	public List<Enrollments> isCompleted(){
		return this.enrollments.stream()
			.filter(enr -> enr.getCourse().getProgress() == 100.0)
			.toList();
	}
	
	public List<Enrollments> noCompleted(){
		return this.enrollments.stream()
				.filter(enr -> enr.getCourse().getProgress() < 100.0)
				.toList();
	}
	
	public List<Enrollments> listAll(){
		return this.enrollments;
		
	}
	
	
	public boolean isBasic() {
		
		List<Enrollments> enro = this.noCompleted();
		
		if(enro.size() <= 2 ) {
			return true;
		}else {
			return false;
		}
		
	}

}
