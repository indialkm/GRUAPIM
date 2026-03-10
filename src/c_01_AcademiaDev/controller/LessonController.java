package c_01_AcademiaDev.controller;

import java.util.List;

import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.Lesson;
import c_01_AcademiaDev.repository.LessonRepository;

public class LessonController {
	
	private LessonRepository repository;
	
	
	public LessonController(LessonRepository repository) {
		this.repository = repository;
	}

	public void adicionar(String lessonName, Course course) {
		
		repository.save(lessonName, course);
		
	}   
	
	public Lesson findByid(int id) {
		
		return repository.findById(id);
		
	}
	
	public List<Lesson> lessonOfCourse(int id){
		
		return repository.lessonOfCourse(id);
		
	}
	
	public void progressCourse(int id) {
		
		repository.lessonCompleted(id);
		
	}

}
