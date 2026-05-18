package com.todolist.list.TarefasController.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.todolist.list.dto.tarefa.TarefaUpdateDTO;
import com.todolist.list.controller.TarefaController;
import com.todolist.list.dto.tarefa.TarefaResponseDTO;
import com.todolist.list.model.Tarefa;
import com.todolist.list.service.TarefaService;

@ExtendWith(MockitoExtension.class)
public class TarefaControllerUnitTest {

    @Mock
    private TarefaService tarefaService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TarefaController tarefaController;

    @Test
    void deveAtualizarTarefaParcialmenteComSucesso_Unitario() {
        Long idTarefa = 1L;

        TarefaUpdateDTO requestDTO = new TarefaUpdateDTO();
        requestDTO.setTitulo(Optional.of("Título Atualizado via Patch"));

        Tarefa tarefaAtualizadaPeloService = new Tarefa();
        tarefaAtualizadaPeloService.setId(idTarefa);
        tarefaAtualizadaPeloService.setTitulo("Título Atualizado via Patch");
        tarefaAtualizadaPeloService.setCategoria("Estudos");

        TarefaResponseDTO responseDTO = new TarefaResponseDTO();
        responseDTO.setId(idTarefa);
        responseDTO.setTitulo("Título Atualizado via Patch");
        responseDTO.setCategoria("Estudos");

        when(tarefaService.atualizarParcial(eq(idTarefa), any(TarefaUpdateDTO.class)))
                .thenReturn(tarefaAtualizadaPeloService);
                
        when(modelMapper.map(tarefaAtualizadaPeloService, TarefaResponseDTO.class))
                .thenReturn(responseDTO);

        ResponseEntity<TarefaResponseDTO> response = tarefaController.atualizarParcial(idTarefa, requestDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Título Atualizado via Patch", response.getBody().getTitulo());
        assertEquals("Estudos", response.getBody().getCategoria());

        verify(tarefaService, times(1)).atualizarParcial(eq(idTarefa), any(TarefaUpdateDTO.class));
        verify(modelMapper, times(1)).map(tarefaAtualizadaPeloService, TarefaResponseDTO.class);
    }
}