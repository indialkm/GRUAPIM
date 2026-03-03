package b_09_SistemaLanchonete.repository;

import java.util.ArrayList;
import java.util.List;

import b_09_SistemaLanchonete.model.Pedido;

public class PedidoRepository {
	
	List<Pedido> pedido = new ArrayList<>();
	
	public void adicionar(Pedido newPedido) {
		
		pedido.add(newPedido);
		
	}

	public Pedido buscar(int idPedido) {
		
		for(Pedido item : pedido) {
			
			if(item.getId() == idPedido) {
				return item;
			}
			
		}
		return null;
		
	}
	
	public Pedido buscarNome(String nome) {
		
		for(Pedido item : pedido) {
		
			if(item.getCliente().getNome().equalsIgnoreCase(nome)) {
				return item;
			}
			
		}
		return null;
	}
}
