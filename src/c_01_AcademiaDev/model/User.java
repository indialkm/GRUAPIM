package c_01_AcademiaDev.model;

import java.util.List;

import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.enums.SubscriptionPlans;

public class User {
	
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected List<Enrollments> enrollents;
	protected List<SuportTickets> tickets;
	protected SubscriptionPlans sub;
	protected Role role;
	
	
	public User(String name, String email, SubscriptionPlans sub, String password, Role role) {
		this.name = name;
		this.email = email;
		this.sub = sub;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Enrollments> getEnrollents() {
		return enrollents;
	}


	public void setEnrollents(List<Enrollments> enrollents) {
		this.enrollents = enrollents;
	}


	public List<SuportTickets> getTickets() {
		return tickets;
	}


	public void setTickets(List<SuportTickets> tickets) {
		this.tickets = tickets;
	}


	public SubscriptionPlans getSub() {
		return sub;
	}


	public void setSub(SubscriptionPlans sub) {
		this.sub = sub;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	/*private emailValidation() {
		
	}*/
	

}
