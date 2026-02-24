package b_09_SistemaLanchonete;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import b_09_SistemaLanchonete.controller.ClienteController;
import b_09_SistemaLanchonete.controller.PedidoController;
import b_09_SistemaLanchonete.model.Cliente;
import b_09_SistemaLanchonete.model.Pedido;
import b_09_SistemaLanchonete.model.Pizza;
import b_09_SistemaLanchonete.model.Prato;
import b_09_SistemaLanchonete.model.Salgadinho;
import b_09_SistemaLanchonete.model.StatusPrato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		       
		        ClienteController clienteCtrl = new ClienteController();
		        PedidoController pedidoCtrl = new PedidoController();

		       
		        Cliente c1 = clienteCtrl.criarCliente("Catarina Alkimim", "1199999-8888", "Rua das Flores, 123");

		        
		        List<Prato> carrinho = new ArrayList<>();

		        Pizza pz = new Pizza(50.0, 
		        		LocalDateTime.
		        		now().plusDays(1), 
		        		0.8, 
		        		StatusPrato.DISPONIVEL, 
		        		"Tomate", 
		        		"Mussarela", 
		        		"Catupiry");
		

		        Salgadinho sg = new Salgadinho(
		        	    8.0,                          
		        	    LocalDateTime.now().plusDays(2), 
		        	    0.2,                          
		        	    StatusPrato.DISPONIVEL,       
		        	    "Frito",                      
		        	    "Trigo",                    
		        	    "Carne"                     
		        	);
		   

		        carrinho.add(pz);
		        carrinho.add(sg);

		        
		        System.out.println("--- INICIANDO NOVO PEDIDO ---");
		        Pedido meuPedido = pedidoCtrl.criarPedido(c1, 10.0, carrinho);
		        
		        
		        meuPedido.setId(1); 

		        
		        System.out.println("\n--- FINALIZANDO PEDIDO ---");
		        pedidoCtrl.encerrarPedido(1, StatusPrato.FINALIZADO);
		
		

	}

}
