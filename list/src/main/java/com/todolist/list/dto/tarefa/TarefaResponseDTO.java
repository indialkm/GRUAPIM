package com.todolist.list.dto.tarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.todolist.list.model.enums.StatusTarefa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TarefaResponseDTO {
	
	Long id;
	String categoria;
	String titulo;
	String descricao;
	StatusTarefa status;
	LocalDateTime dataInicial ;
	LocalDate dataLimite;

}
