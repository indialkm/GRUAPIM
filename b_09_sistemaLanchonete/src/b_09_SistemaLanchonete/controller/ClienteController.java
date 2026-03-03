package b_09_SistemaLanchonete.controller;

import b_09_SistemaLanchonete.model.Cliente;

public class ClienteController {
	
	public Cliente criarCliente(String nome, String telefone, String endereco) {
		
		Cliente cliente = new Cliente(nome, telefone, endereco);
		return cliente;
	};


}
