package b_03_exe_01_listaDeTarefa.model;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	
	private List<String> tarefas = new ArrayList<>();
	
	public List<String> getTarefas() {
		return tarefas;
	}
	

	public void adicionarTarefa(String descricao) {
		this.tarefas.add(descricao);
	}
	
	public void removerTarefa(int indice) {
		this.tarefas.remove(indice);
	}

	public void listarTodasTarefas() {
		int i = 0;
		for(String tarefa : tarefas) {
			
			System.out.printf("Tarefa %d : %s\n", i++, tarefa);
			
		}
	}
	
	
	
	
	
	
	

}
