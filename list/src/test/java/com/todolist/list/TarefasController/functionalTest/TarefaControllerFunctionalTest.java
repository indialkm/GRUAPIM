package com.todolist.list.TarefasController.functionalTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.list.model.Tarefa;
import com.todolist.list.model.User;
import com.todolist.list.repository.TarefaRepository;
import com.todolist.list.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class TarefaControllerFunctionalTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TarefaRepository tarefaRepository;

	private User usuarioSalvo;
	private Tarefa tarefaSalva;

	@BeforeEach
	void setUp() {
		tarefaRepository.deleteAll();
		userRepository.deleteAll();

		User usuario = new User();
		usuario.setNome("Catarina");
		usuario.setEmail("catarina@email.com");
		usuarioSalvo = userRepository.save(usuario);

		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo("Tarefa Antiga");
		tarefa.setCategoria("Faculdade");
		tarefa.setDescricao("Descricao antiga");
		tarefa.setUser(usuarioSalvo);
		tarefa.setDataLimite(LocalDate.now());
		tarefaSalva = tarefaRepository.save(tarefa);
	}

	@Test
	void deveCriarTarefaComSucesso_Historia1_1() throws Exception {
		String jsonPayload = """
				{
				    "titulo": "Entregar relatório do TCC",
					"descricao": "Finalizar a escrita dos capítulos de arquitetura",
					"categoria": "Faculdade",
					"dataLimite": "2026-11-25"
				    
				}
				""";

		mockMvc.perform(post("/tasks/" + usuarioSalvo.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPayload))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.titulo").value("Entregar relatório do TCC"))
				.andExpect(jsonPath("$.categoria").value("Faculdade"))
				.andExpect(jsonPath("$.dataLimite").value("2026-11-25"));
	}

	@Test
	void deveRetornarBadRequestAoCriarTarefaSemTitulo_Historia1_1() throws Exception {
		String jsonPayload = """
				{
				    "descricao": "Tentando criar sem o titulo",
				    "categoria": "Trabalho"
				}
				""";

		mockMvc.perform(post("/tasks/" + usuarioSalvo.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPayload))
				.andExpect(status().isBadRequest());
	}

	@Test
	void deveAtualizarTarefaParcialmenteComSucesso_Historia1_2() throws Exception {
		String jsonPayload = """
				{
				    "titulo": "Título Alterado Funcional"
				}
				""";

		mockMvc.perform(patch("/tasks/" + tarefaSalva.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPayload))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.titulo").value("Título Alterado Funcional"));
	}

	@Test
	void deveRetornarNotFoundAoAtualizarTarefaInexistente_Historia1_2() throws Exception {
		String jsonPayload = """
				{
				    "titulo": "Nova tarefa"
				}
				""";

		mockMvc.perform(patch("/tasks/999999")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPayload))
				.andExpect(status().isNotFound());
	}

	@Test
	void deveExcluirTarefaComSucesso_Historia1_3() throws Exception {
		mockMvc.perform(delete("/tasks/" + tarefaSalva.getId()))
				.andExpect(status().isNoContent());
	}

	@Test
	void deveRetornarNotFoundAoExcluirTarefaInexistente_Historia1_3() throws Exception {
		mockMvc.perform(delete("/tasks/999999"))
				.andExpect(status().isNotFound());
	}

	@Test
	void deveListarTarefasComPaginaPadrao_Historia2_1() throws Exception {
		mockMvc.perform(get("/tasks/user/" + usuarioSalvo.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isArray());
	}

	@Test
	void deveListarTarefasComPaginaETamanhoCustomizados_Historia2_1() throws Exception {
		mockMvc.perform(get("/tasks/user/" + usuarioSalvo.getId())
				.param("page", "0")
				.param("size", "5")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isArray());
	}

	@Test
	void deveFiltrarTarefasPorCategoria_Historia2_2() throws Exception {
		mockMvc.perform(get("/tasks/user/" + usuarioSalvo.getId() + "/categoria/" + tarefaSalva.getCategoria())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isArray());
	}
	
	@Test
	void deveFinalizarTarefaNoPrazoComSucesso() throws Exception {
		
		tarefaSalva.setDataLimite(LocalDate.now().plusDays(1));
		tarefaRepository.save(tarefaSalva);

		
		mockMvc.perform(patch("/tasks/" + tarefaSalva.getId() + "/check")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("FINALIZADO")); 
	}

	@Test
	void deveFinalizarTarefaComAtrasoComSucesso() throws Exception {
		
		tarefaSalva.setDataLimite(LocalDate.now().minusDays(1));
		tarefaRepository.save(tarefaSalva);

	
		mockMvc.perform(patch("/tasks/" + tarefaSalva.getId() + "/check")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("FINALIZADA_COM_ATRASO")); 
	}
}