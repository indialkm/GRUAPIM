package c_01_AcademiaDev.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.Enrollments;
import c_01_AcademiaDev.model.User;
import c_01_AcademiaDev.model.enums.DifficultyLevel;
import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.enums.StatusCourse;
import c_01_AcademiaDev.model.enums.SubscriptionPlans;

import java.lang.reflect.Field;

public class ExportService {
	
	public String exportarParaCSV(List<?> lista, List<String> colunas) {
	    if (lista == null || lista.isEmpty()) return "Lista vazia.";

	    StringBuilder csv = new StringBuilder();
	    

	    StringJoiner cabecalho = new StringJoiner(";");
	    colunas.forEach(c -> cabecalho.add(c.toUpperCase()));
	    csv.append(cabecalho.toString()).append("\n");

	    
	    for (Object obj : lista) {
	        StringJoiner linha = new StringJoiner(";");
	        Class<?> clazz = obj.getClass();
	        
	        for (String col : colunas) {
	            try {
	              
	                Field field = clazz.getDeclaredField(col);
	                field.setAccessible(true); 
	                Object value = field.get(obj);
	                linha.add(value != null ? value.toString() : "");
	            } catch (NoSuchFieldException | IllegalAccessException e) {
	                linha.add("N/A"); 
	            }
	        }
	        csv.append(linha.toString()).append("\n");
	    }
	    return csv.toString();
	}
	
	//Cursos por Nível 
    public List<Course> cursosPorNivel(List<Course> todosCursos, DifficultyLevel nivel) {
        return todosCursos.stream()
                .filter(c -> c.getLevel() == nivel)
                .sorted(Comparator.comparing(Course::getTitle))
                .toList();
    }

    // Instrutores Únicos em Cursos Ativos
    public List<String> instrutoresUnicos(List<Course> todosCursos) {
        return todosCursos.stream()
                .filter(c -> c.getStatus() == StatusCourse.ACTIVE)
                .map(Course::getInstructorName)
                .distinct()
                .toList();
    }

    //  Alunos Agrupados por Plano
    public Map<SubscriptionPlans, List<User>> alunosPorPlano(List<User> todosUsuarios) {
        return todosUsuarios.stream()
                .filter(u -> u.getRole() == Role.STUDENT)
                .collect(Collectors.groupingBy(User::getSub));
    }

    // Média Geral de Progresso
    public double mediaProgressoGeral(List<Enrollments> todasMatriculas) {
        return todasMatriculas.stream()
                .mapToDouble(e -> e.getCourse().getProgress())
                .average()
                .orElse(0.0);
    }

    // Aluno com maior número de Matrículas Ativas
    public User alunoTop(List<Enrollments> todasMatriculas) {
        return todasMatriculas.stream()
                .filter(e -> e.getCourse().getProgress() < 1.0) 
                .collect(Collectors.groupingBy(Enrollments::getStudent, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

}
