package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import c_01_AcademiaDev.model.User;
import c_01_AcademiaDev.model.enums.Role;
import c_01_AcademiaDev.model.enums.SubscriptionPlans;

public class UserRepository {
	
	/*
	 * Questão de acesso de sessão
	 * 
	 * */
	
	private List<User> users = new ArrayList<>();
	private int nextId = 1;

	// Salva 
	public void save(String name, String email, SubscriptionPlans sub, String password, Role role) {
		
		boolean validationEmail = validandoEmail(email);
		
		if(validationEmail == false) {
		
		User us = new User(name, email, sub, password, role);
		
		if(us.getId() == 0) {
			us.setId(nextId++);
		}
		
		users.add(us);
	}else {
		System.out.println("E-mail já usado, tente outro");
		
	} }
		
	
	
	public List<User> findAll(){
		return users;
	}
	
	public Optional<User> findbyId(int id){
		return users.stream()
				.filter(u -> u.getId() == id)
				.findFirst();
	}
	
	//Procura por Role, autenticar Role
	
	public List<User> findByRole(Role role){
		
		return users.stream()
				.filter( u ->  u.getRole().equals(role))
				.toList();
	
	}
	
	//Procurar por email validar login
	
	public Optional<User> findByEmail(String email){
		
	    return users.stream()
	            .filter(u -> u.getEmail().equals(email))
	            .findFirst();
	}
	
	
	
	
	// Métodos complementares
	public boolean validandoEmail(String emailCadastrado) {
		
		return users.stream()
				.anyMatch(u -> u.getEmail().equals(emailCadastrado));
			

	}}

