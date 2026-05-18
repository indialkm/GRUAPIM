package com.todolist.list.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.todolist.list.dto.user.UserRequestDTO;
import com.todolist.list.dto.user.UserResponseDTO;
import com.todolist.list.model.User;
import com.todolist.list.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<UserResponseDTO> criandoUsuario(@RequestBody UserRequestDTO dto) {
		
		var user = userService.criar(dto);
		UserResponseDTO response =  modelMapper.map(user, UserResponseDTO.class);	
				return ResponseEntity
				        .status(HttpStatus.CREATED)
				        .body(response); 
	}
	
}
