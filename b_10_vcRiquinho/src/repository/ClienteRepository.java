package repository;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteRepository {
	
	private List<Cliente> clientes = new ArrayList<>();

	//CRIAR
	public void adicionar(Cliente cliente) {
		clientes.add(cliente);
	}
	
	//BUSCAR TODOS
	public List<Cliente> listarTodos() {
        return clientes;
    }
	
	//BUSCAR POR DOCUMENTO
	public Cliente buscarPorDocumento(String documento) {
        for (Cliente c : clientes) {
        	
            if (c.getDocumento().equals(documento)) {
                return c;
            }
        }
        return null; 
    }
	
	//REMOVER
	public boolean remover(String documento) {
        Cliente c = buscarPorDocumento(documento);
        if (c != null) {
            return clientes.remove(c);
        }
        return false;
    }
	
	//ATUALIZAR
	public boolean atualizar(String documento, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
         
            if (clientes.get(i).getDocumento().equalsIgnoreCase(documento)) {
            	
            	if (!documento.equals(clienteAtualizado.getDocumento())) {
                    System.out.println("LOG: Tentativa de alterar documento negada!");
                    return false; 
                }
              
                clientes.set(i, clienteAtualizado);
                return true;
            }
        }
        return false;
    }
	
	
}
