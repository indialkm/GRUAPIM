package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.List;

import c_01_AcademiaDev.model.Course;
import c_01_AcademiaDev.model.Lesson;
import c_01_AcademiaDev.model.enums.Status;

public class LessonRepository {
	
	private List<Lesson> lessons = new ArrayList<>();
	private int nextId = 1;

	public void save(String lessonName, Course course) {
		
			Lesson lesson = new Lesson(0, lessonName, course);
			lesson.setId(this.gerationId(lesson.getId()));	
			lessons.add(lesson);
			
	}
	
	public List<Lesson> lessonOfCourse(int idCourse){
		
		return lessons.stream()
				.filter(l -> l.getCourse().getId() == idCourse)
				.toList();
		
	}
	
	public Lesson findById(int id) {
		
		return lessons.stream()
				.filter( l -> l.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public void lessonCompleted(int id) {
		
		lessons.stream()
        .filter(l -> l.getId() == id)
        .findFirst()
        .ifPresent(l -> l.setStatus(Status.COMPLETED));
		
	}
	
	
	
	
	
	
	/***********GERADOR ID*************/
	public int gerationId(int id) {
		if(id == 0) {
		return nextId++;
		}
		return 0;
	}
	/************************/
	

}
