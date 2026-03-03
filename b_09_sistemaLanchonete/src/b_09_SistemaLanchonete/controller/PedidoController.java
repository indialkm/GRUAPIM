package b_09_SistemaLanchonete.controller;

import java.util.List;

import b_09_SistemaLanchonete.model.Cliente;
import b_09_SistemaLanchonete.model.Pedido;
import b_09_SistemaLanchonete.model.Prato;
import b_09_SistemaLanchonete.model.StatusPrato;
import b_09_SistemaLanchonete.repository.PedidoRepository;

public class PedidoController {
	
	PratoController pratoController = new PratoController();
	private PedidoRepository repository = new PedidoRepository();
	

	public Pedido criarPedido(Cliente cliente, double taxaServico, List<Prato> pratos) {
		
		Pedido pedido = new Pedido(cliente, taxaServico, pratos);
		
		for(Prato prato : pratos) {
		
			pratoController.adicionarAoCardapio(prato);
		
		}
		
		repository.adicionar(pedido);
		
		System.out.println("O pedido " + pedido.getId() + "\nCliente: " + pedido.getCliente().getNome() + "\nPratos: ");
		
		pratos.forEach(item -> System.out.println(item));
		
		return pedido;
		
	}
	
	public Pedido buscarId(int idPedido) {
		
		return repository.buscar(idPedido);
		
	}
	
	public Pedido buscarCliente(String nome) {
		
		return repository.buscarNome(nome);
		
	}
	
	public void encerrarPedido(int idPedido, StatusPrato status) {
		
		Pedido pedidoEncontrado = buscarId(idPedido);
		if(pedidoEncontrado != null) {
			
			if(status == StatusPrato.FINALIZADO) {
				
			System.out.println("Pedido " + idPedido + "Finalizado com sucesso");
		
			this.gerarNotaFiscal(pedidoEncontrado);
			
			
		}
			
	
			
		}
	
	}
	
	
	
	public void gerarNotaFiscal(Pedido pedido) {
	    System.out.println("=========================================");
	    System.out.println("          QUASE TRÊS LANCHES             ");
	    System.out.println("=========================================");
	    System.out.println("Pedido ID: " + pedido.getId());
	    System.out.println("Cliente: " + pedido.getCliente().getNome());
	    System.out.println("Endereço: " + pedido.getCliente().getEndereco());
	    System.out.println("-----------------------------------------");
	    System.out.println("ITENS DO PEDIDO:");

	    double subtotalItens = 0.0;

	    
	    for (Prato item : pedido.getItensConsumidos()) {
	        System.out.println("- " + item.toString());
	       
	        subtotalItens += item.calcularPreco();
	    }

	    double totalGeral = subtotalItens + pedido.getTacaServico();

	    System.out.println("-----------------------------------------");
	    System.out.printf("Subtotal Itens: R$ %.2f\n", subtotalItens);
	    System.out.printf("Taxa de Serviço: R$ %.2f\n", pedido.getTacaServico());
	    System.out.println("-----------------------------------------");
	    System.out.printf("TOTAL A PAGAR: R$ %.2f\n", totalGeral);
	    System.out.println("=========================================");
	}

}
