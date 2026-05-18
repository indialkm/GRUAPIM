package com.todolist.list.service;


import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.todolist.list.dto.tarefa.TarefaRequestDTO;
import com.todolist.list.dto.tarefa.TarefaUpdateDTO;
import com.todolist.list.exception.ResourceNotFoundException;
import com.todolist.list.model.Tarefa;
import com.todolist.list.model.User;
import com.todolist.list.model.enums.StatusTarefa;
import com.todolist.list.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private UserService u_service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Tarefa buscarPorId(Long id)
	{
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
	}
	
	public Tarefa criar(Long idUser, TarefaRequestDTO dto)
	{
		User user = u_service.buscarId(idUser);
		Tarefa tarefa = modelMapper.map(dto, Tarefa.class);
		tarefa.setUser(user);
		return repository.save(tarefa);
		
	}
	
	public Tarefa atualizarParcial(Long idTarefa, TarefaUpdateDTO dto) {
		
		Tarefa tarefaExistente = buscarPorId(idTarefa);
	
		dto.getCategoria().ifPresent(tarefaExistente::setCategoria);
	    dto.getTitulo().ifPresent(tarefaExistente::setTitulo);
	    dto.getDescricao().ifPresent(tarefaExistente::setDescricao);
	    dto.getDataLimite().ifPresent(tarefaExistente::setDataLimite);
		
		return repository.save(tarefaExistente);
		
	}
	
	
	public void deletar(Long idTarefa) {
		Tarefa tarefa = buscarPorId(idTarefa);
		repository.delete(tarefa);
	}
	
	public Page<Tarefa> buscarTarefasPaginadas(Long userId, Pageable page){
		return repository.buscarTarefas(userId, page);
	}
	
	public Page<Tarefa> buscarPorCategoriaPaginada(Long userId, String categoria, Pageable pageable) {
		return repository.findByUserIdAndCategoriaIgnoreCase(userId, categoria, pageable);
	}
	
	
	public Tarefa isCheck(Long idTarefa){
		Tarefa tarefa = buscarPorId(idTarefa);
		
		if (tarefa.getDataLimite().isBefore(LocalDate.now())) {
	        tarefa.setStatus(StatusTarefa.FINALIZADA_COM_ATRASO);
	    } else {
	        tarefa.setStatus(StatusTarefa.FINALIZADO);
	    }
	
		return repository.save(tarefa);
	}
	
	
}
