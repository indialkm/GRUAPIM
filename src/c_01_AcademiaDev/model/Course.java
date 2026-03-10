package c_01_AcademiaDev.model;

import java.util.List;

import c_01_AcademiaDev.model.enums.DifficultyLevel;
import c_01_AcademiaDev.model.enums.StatusCourse;

public class Course {
	
	private int id;
	private String title;
	private String description;
	private String instructorName;
	private DifficultyLevel level;
	private StatusCourse status;
	private double progress;
	private Lesson lesson;
	
	
	public Course(int id, String title, String description, String instructorName, DifficultyLevel level,
			StatusCourse status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.instructorName = instructorName;
		this.level = level;
		this.status = status;
		this.progress = 0.0;
	}

	private List<Enrollments> enrollments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public DifficultyLevel getLevel() {
		return level;
	}

	public void setLevel(DifficultyLevel level) {
		this.level = level;
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	public List<Enrollments> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}

	public StatusCourse getStatus() {
		return status;
	}

	public void setStatus(StatusCourse status) {
		this.status = status;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	
	
	
}
