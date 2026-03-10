package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import c_01_AcademiaDev.controller.LessonController;
import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.Lesson;
import c_01_AcademiaDev.model.enums.DifficultyLevel;
import c_01_AcademiaDev.model.enums.Status;
import c_01_AcademiaDev.model.enums.StatusCourse;

public class CourseRepository {
	
	private List<Course> courses = new ArrayList<>();
	private LessonController lesson;
	private LessonRepository lessonR;
	private int nextId = 1;
	
	
	public CourseRepository(LessonController lesson, LessonRepository lessonR) {
		this.lesson = lesson;
		this.lessonR = lessonR;
	}

	public void save(String title, String description, String instructorName, DifficultyLevel level,
			StatusCourse status) {
			
		Course c = new Course(0, title, description, instructorName, level, status);
		
			if(c.getId() == 0) {
				c.setId(nextId++);
			}
			
			
			
		courses.add(c);
	}
		
	public void listAllCoursesText(List<Course> courses) {
	    System.out.println("--- LISTAGEM DE CURSOS ---");
	    
	    for (Course c : courses) {
	        System.out.println("ID: " + c.getId() + 
	                           " | Titulo: " + c.getTitle() + 
	                           " | Instrutor: " + c.getInstructorName() + 
	                           " | Nivel: " + c.getLevel() + 
	                           " | Status: " + c.getStatus());
	                           
	    }
	    
	}
	
	public Optional<Course> findById(int id) {
		
		return courses.stream()
				.filter(c -> c.getId() == id)
				.findFirst();
		
	}
	
	public double attProgress(int idCourse) {
		
		Course courseProgress = findById(idCourse)
	            .orElse(null);

	    if (courseProgress == null) {
	        System.out.println("Nenhuma aula encontrada para o curso ID: " + idCourse);
	        return 0.0;
	    }

	    List<Lesson> lessons = lesson.lessonOfCourse(idCourse);
	    
	    if (lessons.isEmpty()) return 0.0;
		
		long concluidas = lessons.stream()
		.filter(l -> l.getStatus() == Status.COMPLETED)
		.count();
		
		if (lessons.isEmpty()) {
	        System.out.println("Nenhuma aula encontrada para o curso ID: " + idCourse);
	        return 0.0; 
	    }
		
		double total = lessons.size();
		double value = (double)(concluidas / total);
	    
		courseProgress.setProgress(value);
		
		return value;
		
	
	}
	
	public List<Course> listAll(){
		return courses;
	}
	
	
	public List<Course> isActive(){
		
		return courses.stream()
				.filter(u -> u.getStatus() == StatusCourse.ACTIVE)
				.toList();
		
	}
	
	
	
	
}
