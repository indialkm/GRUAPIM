package com.todolist.list.dto.tarefa;

import java.time.LocalDate;
import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TarefaUpdateDTO {
	
	Optional<String> categoria = Optional.empty();
    Optional<String> titulo = Optional.empty();
    Optional<String> descricao = Optional.empty();
    Optional<LocalDate> dataLimite = Optional.empty();
	
}
