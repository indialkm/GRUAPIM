package b_03_exe_01_listaDeTarefa;

import java.util.Scanner;

import b_03_exe_01_listaDeTarefa.model.ToDoList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		ToDoList lista = new ToDoList();
		
		
		int j = 0;
		int menu = 0;
	
		do {
			
			System.out.println("********Lista de Tarefas**********\n"
							 + "Menu\n"
							  + "| 1 | - Adicionar tarefa\n"
							  + "| 2 | - Remover tarefa\n"
							  + "| 3 | - Listar todas as tarefas\n"
							  + "| 0 | - Sair\n");
			
			menu = scan.nextInt();
			
			switch(menu){
			case 1:
				
				System.out.println("Adicionar tarefa \n");
				
					scan.nextLine();
					System.out.println("Digite uma tarefa: ");
					String stringScan = scan.nextLine();
					lista.adicionarTarefa(stringScan);
				
			
				break;
				
			case 2:
				
				System.out.println("Remover tarefa \n");
				
				System.out.println("Remover tarefa, digite o indice: ");
				lista.removerTarefa(scan.nextInt());
				
				break;
			case 3:
				
System.out.println("Todas tarefas \n");
				
				lista.listarTodasTarefas();
				
				break;
			case 0:
				
				scan.close();
				j = 1;
			
				break;
			default:
				
				System.out.println("Valor errado, por favor siga os valores do menu");
				break;
			}	
			
			
		}while(j == 0);
		

	}

}
