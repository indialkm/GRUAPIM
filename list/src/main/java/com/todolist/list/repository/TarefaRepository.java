package com.todolist.list.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todolist.list.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	@Query("SELECT t FROM Tarefa t WHERE t.user.id = :idUsuario")
	Page<Tarefa> buscarTarefas(@Param("idUsuario") Long idUsuario, Pageable page);
	
	
	Page<Tarefa> findByUserIdAndCategoriaIgnoreCase(Long userId, String categoria, Pageable pageable);

}
