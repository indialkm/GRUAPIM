package c_01_AcademiaDev.model;

import java.util.List;

public class Progress {
	
	private int id;
	private List<Course> courses;
	private double level;
	
	public Progress(int id) {
		this.id = id;
		this.level = 0.0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public double getLevel() {
		return level;
	}
	public void setLevel(double level) {
		this.level = level;
	}

}
