package com.todolist.list.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import com.todolist.list.model.enums.StatusTarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Entity
@Table(name="tb_tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusTarefa status = StatusTarefa.NAO_INICIADA;
	
	@NotNull
	private String categoria;
	
	@Size(min = 3, max = 30)
	@NotBlank(message = "O título é obrigatório")
	private String titulo;
	private String descricao;
	private LocalDateTime dataInicial = LocalDateTime.now();
	
	@NotNull(message = "A data limite é obrigatória")
	@FutureOrPresent(message = "A data limite não pode ser uma data passada")
	private LocalDate dataLimite;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	/*public void setDataLimite(LocalDate dataLimite) {
	
		this.dataLimite = (!dataLimite.isBefore(LocalDate.now())) ? dataLimite : null;
	}*/
	
	
	
}
