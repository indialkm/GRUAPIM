package c_01_AcademiaDev.controller;

import java.util.List;

import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.enums.DifficultyLevel;
import c_01_AcademiaDev.model.enums.StatusCourse;
import c_01_AcademiaDev.model.session.UserSession;
import c_01_AcademiaDev.repository.CourseRepository;
import c_01_AcademiaDev.repository.LessonRepository;
import c_01_AcademiaDev.security.SecurityService;

public class CourseController {
	
	private CourseRepository repository;
	private SecurityService security;
	private UserSession session;
	private LessonController lessonC;
	private LessonRepository lessonR;
	
	
	/*Explicar pro prof que eu sei que isso aqui pode gerar um problema de não pdoer exibir 
	 * o curso para pessoas que não estão dentro do site, contudo, como isso não é bem explicito
	 * assim facilita pra mim kkkk*/

	public CourseController(UserSession session, SecurityService security,CourseRepository repository,  LessonController lessonC, LessonRepository lessonR) {
		this.session = session;
		this.security = security;
		this.repository = repository;
		this.lessonC = lessonC;
		this.lessonR = lessonR;
	}

	public void register(String title, String description, String instructorName, DifficultyLevel level,
			StatusCourse status) {
		
		if (security.isAdmin(session)) {
		    repository.save(title, description, instructorName, level, status);
		} else {
		    System.out.println("Você não tem permissão!");
		}
		
	}
	
	public void registerLesson(String name, int idCurso) {
	
		List<Course> courseAc =  repository.isActive();
		Course curso = courseAc.stream()
						.filter( c -> c.getId() == idCurso)
						.findFirst()
						.orElse(null);
		
		lessonC.adicionar(name, curso);
		 
	}
	
	public double registerProgress(int idCurso) {
	
		return repository.attProgress(idCurso);	
		
	}
	
	
	
	public void listCourseActive() {
	    
	    List<Course> courses = repository.isActive();

	    courses.forEach(u -> System.out.println(
	               " | Id: " + u.getId() + 
	               " | Nome: " + u.getTitle() + 
	               " | Nível: " + u.getLevel() + 
	               " | Instrutor: " + u.getInstructorName()
	           ));
	}
	
	public List<Course> getActive(){
		return repository.isActive();
	}

}
