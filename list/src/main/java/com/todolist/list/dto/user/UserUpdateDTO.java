package com.todolist.list.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
public class UserUpdateDTO {
	
	@NotNull
	String nome;
	@Email
	String email;
	
	

}
