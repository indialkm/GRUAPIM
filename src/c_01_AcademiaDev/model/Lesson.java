package c_01_AcademiaDev.model;


import c_01_AcademiaDev.model.enums.Status;

public class Lesson {
	
	private int id;
	private String lessonName;
	private Course course;
	private Status status;
	
	public Lesson(int id, String lessonName, Course course) {
		this.id = id;
		this.lessonName = lessonName;
		this.course = course;
		this.status = Status.START;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
