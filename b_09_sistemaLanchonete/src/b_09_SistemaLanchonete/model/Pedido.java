package b_09_SistemaLanchonete.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private static int contadorId = 0;
	
	private int id;
	private Cliente cliente;
	private double tacaServico;
	private List<Prato> itensConsumidos = new ArrayList<>();
	
	public Pedido( Cliente cliente, double tacaServico, List<Prato> itensConsumidos) {
		this.id = contadorId ++;
		this.cliente = cliente;
		this.tacaServico = tacaServico;
		this.itensConsumidos = itensConsumidos;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTacaServico() {
		return tacaServico;
	}

	public void setTacaServico(double tacaServico) {
		this.tacaServico = tacaServico;
	}

	public List<Prato> getItensConsumidos() {
		return itensConsumidos;
	}

	public void setItensConsumidos(List<Prato> itensConsumidos) {
		this.itensConsumidos = itensConsumidos;
	}
	
}
