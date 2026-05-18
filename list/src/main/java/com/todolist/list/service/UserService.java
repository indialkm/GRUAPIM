package com.todolist.list.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.list.dto.user.UserRequestDTO;
import com.todolist.list.model.User;
import com.todolist.list.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
public class UserService {
	
	@Autowired
	private UserRepository u_repository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	public User criar(UserRequestDTO dto) {	
		User user = modelMapper.map(dto, User.class);
		user.getTarefas().forEach(tarefa -> tarefa.setUser(user));
		return u_repository.save(user);
	}
	
	public User buscarId(Long id)
	{
		return u_repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
	}
	
	

}
