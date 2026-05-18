package com.todolist.list.dto.tarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class TarefaRequestDTO {

	String categoria;
	String titulo;
	String descricao;
	LocalDate dataLimite;

}
