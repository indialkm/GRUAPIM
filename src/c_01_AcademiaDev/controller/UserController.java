package c_01_AcademiaDev.controller;

import c_01_AcademiaDev.model.enums.SubscriptionPlans;
import c_01_AcademiaDev.model.enums.Role;

import c_01_AcademiaDev.repository.UserRepository;

public class UserController {
	
	private final UserRepository userRep;


	public UserController(UserRepository userRep) {
		this.userRep = userRep;
		
	}

	public void save(String name, String email, SubscriptionPlans tipoPlan, String password, Role role) {

		userRep.save(name, email, tipoPlan, password, role);
		
	}
	
	public void listAllUserText(){
	
	userRep.findAll().forEach(u -> System.out.println("ID: " + u.getId() + " | Nome: " + u.getName() + " | Role: " + u.getRole() + " | Plano: " + u.getSub()));
		 
	}
	
	

}
