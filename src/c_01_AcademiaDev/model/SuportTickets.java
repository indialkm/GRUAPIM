package c_01_AcademiaDev.model;

import java.time.LocalDateTime;
import java.util.List;

public class SuportTickets {
	
	private int id;
	private User student;
	private String title ;
	private LocalDateTime startData;
	private String message;
	
	public SuportTickets(int id, User student, String title, String Message) {
		this.id = id;
		this.student = student;
		this.title = title;
		this.startData = LocalDateTime.now();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getStartData() {
		return startData;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
