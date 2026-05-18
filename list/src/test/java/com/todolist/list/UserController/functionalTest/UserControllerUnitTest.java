package com.todolist.list.UserController.functionalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.todolist.list.controller.UserController;
import com.todolist.list.dto.user.UserRequestDTO;
import com.todolist.list.dto.user.UserResponseDTO;
import com.todolist.list.model.User;
import com.todolist.list.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserController userController;

    @Test
    void deveCriarUsuarioComSucesso_Unitario() {
        // ========== GIVEN ==========
        UserRequestDTO requestDTO = new UserRequestDTO();
        requestDTO.setNome("Catarina");
        requestDTO.setEmail("catarina@email.com");

        User userRetornadoPeloService = new User();
        userRetornadoPeloService.setNome("Catarina");
        userRetornadoPeloService.setEmail("catarina@email.com");
        ReflectionTestUtils.setField(userRetornadoPeloService, "id", 1L);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setNome("Catarina");
        responseDTO.setEmail("catarina@email.com");

        // Configurandos os comportamentos dos dublês (Mocks)
        when(userService.criar(any(UserRequestDTO.class))).thenReturn(userRetornadoPeloService);
        when(modelMapper.map(userRetornadoPeloService, UserResponseDTO.class)).thenReturn(responseDTO);

        // ========== WHEN ==========
        // Executa a ação real do controller (Sem as barras de comentário //)
        ResponseEntity<UserResponseDTO> response = userController.criandoUsuario(requestDTO);

        // ========== THEN ==========
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());

        // Verifica se o service foi acionado corretamente
        verify(userService, times(1)).criar(any(UserRequestDTO.class));
    }
}