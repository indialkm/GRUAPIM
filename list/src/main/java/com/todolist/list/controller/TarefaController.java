package com.todolist.list.controller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.list.dto.tarefa.TarefaRequestDTO;
import com.todolist.list.dto.tarefa.TarefaResponseDTO;
import com.todolist.list.dto.tarefa.TarefaUpdateDTO;
import com.todolist.list.model.Tarefa;
import com.todolist.list.service.TarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tasks")
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/{idUser}")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Criar nova tarefa", description = "Cadastra uma nova tarefa vinculada a um usuário específico")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "210", description = "Tarefa criada com sucesso"),
		@ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	})
	public ResponseEntity<TarefaResponseDTO> criarTarefa(
			@PathVariable Long idUser, 
	        @RequestBody @Valid TarefaRequestDTO request)
	{
		var tarefa = tarefaService.criar(idUser, request);
		TarefaResponseDTO response = modelMapper.map(tarefa, TarefaResponseDTO.class);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	@PatchMapping("/{idTarefa}")
	@Operation(summary = "Atualizar tarefa parcialmente", description = "Modifica apenas os campos enviados na requisição de uma tarefa existente")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
		@ApiResponse(responseCode = "400", description = "Dados de atualização inválidos"),
		@ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
	})
	public ResponseEntity<TarefaResponseDTO> atualizarParcial(
	        @PathVariable Long idTarefa, 
	        @RequestBody @Valid TarefaUpdateDTO request) {
	        
	    var tarefaAtualizada = tarefaService.atualizarParcial(idTarefa, request);
	    TarefaResponseDTO response = modelMapper.map(tarefaAtualizada, TarefaResponseDTO.class);
	    
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{idTarefa}")
	@Operation(summary = "Buscar tarefa por ID", description = "Retorna os detalhes de uma única tarefa baseada no seu identificador único")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
	})
	public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long idTarefa) {
		Tarefa tarefa = tarefaService.buscarPorId(idTarefa);
		TarefaResponseDTO response = modelMapper.map(tarefa, TarefaResponseDTO.class);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{idTarefa}")
	@Operation(summary = "Excluir uma tarefa", description = "Remove permanentemente uma tarefa do banco de dados")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "204", description = "Tarefa excluída com sucesso", content = @Content),
		@ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
	})
	public ResponseEntity<Void> deletar(@PathVariable Long idTarefa) {
		tarefaService.deletar(idTarefa);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/{idUser}")
	@Operation(summary = "Listar tarefas paginadas do usuário", description = "Retorna uma lista paginada de todas as tarefas de um usuário específico")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Listagem gerada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
	})
	public ResponseEntity<Page<TarefaResponseDTO>> buscarTarefasPaginadas(
			@PathVariable Long idUser, 
			@PageableDefault(size = 10) Pageable pageable) {
		Page<Tarefa> tarefas = tarefaService.buscarTarefasPaginadas(idUser, pageable);
		Page<TarefaResponseDTO> response = tarefas.map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
		return ResponseEntity.ok(response);
	}

	@PatchMapping("/{idTarefa}/check")
	@Operation(summary = "Finalizar uma tarefa", description = "Altera o status da tarefa para concluída (check)")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Tarefa finalizada com sucesso"),
		@ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
	})
	public ResponseEntity<TarefaResponseDTO> finalizarTarefa(@PathVariable Long idTarefa) {
		Tarefa tarefaFinalizada = tarefaService.isCheck(idTarefa);
		TarefaResponseDTO response = modelMapper.map(tarefaFinalizada, TarefaResponseDTO.class);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/user/{idUser}/categoria/{categoria}")
	@Operation(summary = "Buscar tarefas por categoria", description = "Retorna uma lista paginada de tarefas filtradas por categoria para um usuário")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Filtro executado com sucesso"),
		@ApiResponse(responseCode = "404", description = "Usuário ou categoria não encontrados")
	})
	public ResponseEntity<Page<TarefaResponseDTO>> buscarPorCategoria(
	        @PathVariable Long idUser,
	        @PathVariable String categoria,
	        @PageableDefault(size = 10) Pageable pageable) {
	    Page<Tarefa> tarefas = tarefaService.buscarPorCategoriaPaginada(idUser, categoria, pageable);
	    Page<TarefaResponseDTO> response = tarefas.map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class));
	    return ResponseEntity.ok(response);
	}

}
