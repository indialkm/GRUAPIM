package c_01_AcademiaDev.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import c_01_AcademiaDev.model.SuportTickets;
import c_01_AcademiaDev.model.User;

public class SuportTicketsRepository {
	
	private Queue<SuportTickets> filaDeEspera = new LinkedList<>();
    private int nextId = 1;

    
    public void abrirTicket(User aluno, String titulo, String mensagem) {
        SuportTickets novoTicket = new SuportTickets(nextId++, aluno, titulo, mensagem);
        filaDeEspera.add(novoTicket);
        System.out.println("Ticket #" + novoTicket.getId() + " enviado por " + aluno.getName());
    }

    
    public void atenderProximo() {
       
        SuportTickets ticketParaAtender = filaDeEspera.poll(); 

        if (ticketParaAtender != null) {
            System.out.println("--- ATENDENDO AGORA ---");
            System.out.println("Ticket: " + ticketParaAtender.getTitle());
            System.out.println("Aluno: " + ticketParaAtender.getStudent().getName());
            System.out.println("Data: " + ticketParaAtender.getStartData());
        } else {
            System.out.println("A fila está vazia! Todos os alunos foram ajudados.");
        }
    }
	

}
