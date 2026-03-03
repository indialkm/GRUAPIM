package controller;


import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaCDI;
import model.ContaCorrente;
import model.ContaInvestimentoAutomatico;
import model.Produto;
import model.ProdutoRendaFixa;
import model.ProdutoRendaVariavel;
import repository.ClienteRepository;
import repository.ContaRepository;

public class ContaController {
	
	private ClienteRepository clienteRepo;
	private ProdutoController produtoController;
	private ContaRepository contaRepository;
	
	public ContaController(ClienteRepository clienteRepo, ProdutoController produtoController,
			ContaRepository contaRepository) {
		this.clienteRepo = clienteRepo;
		this.produtoController = produtoController;
		this.contaRepository = contaRepository;
	}

	public void criarConta(String documentoCliente, String numero, int tipo) {
       
        Cliente cliente = clienteRepo.buscarPorDocumento(documentoCliente);
       

        if (cliente != null) {
            Conta novaConta = null;

            if (tipo == 1) {
                novaConta = new ContaCorrente(numero, 0.0);
            } else if (tipo == 2) {
                novaConta = new ContaCDI(numero, 0.0, 0.50);
            } else if (tipo == 3) {
                novaConta = new ContaInvestimentoAutomatico(numero, 0.0);     
            }

            if (novaConta != null) {
                cliente.getContas().add(novaConta);
                System.out.println("Conta " + numero + " criada para " + cliente.getNome());
                this.adicionarProduto(documentoCliente, numero);
            }
        } else {
            System.out.println("Erro: Cliente não encontrado!");
        }
    }
    
    public void adicionarProduto(String documento, String numero) {
    	
    	Conta conta = contaRepository.buscarPorNumero(documento, numero);
    	ContaInvestimentoAutomatico cia = (ContaInvestimentoAutomatico) conta;
    	Produto prod = produtoController.escolherRenda();
    	
    	if (prod instanceof ProdutoRendaFixa) {
    		cia.adicionar(prod);
    		System.out.println("Produto" + prod.getNome() + " do tipo Renda fixa \nAdicionado a conta investimento!");
    		
    	}
    	else if(prod instanceof ProdutoRendaVariavel) {
    		cia.adicionar(prod);
    		System.out.println("Produto" + prod.getNome() + " do tipo Renda Variavel \nAdicionado a conta investimento!");
    		
    	}
    	else {
    		
    		System.out.println("Tipo de conta não eonctrado");
    		
    	}
    }
	
	public void realizarSimulacao(Cliente cliente, int dias) {
        
        System.out.println("Simulação para " + cliente.getNome() + " em " + dias + " dias:");

        for (Conta conta : cliente.getContas()) {
        	double rendimento = 0;

            if (conta instanceof ContaCorrente) {
                rendimento = 0;
            } 
            
            else if (conta instanceof ContaCDI) {
            		
            	ContaCDI cdi = (ContaCDI) conta; //casting de objetos
                rendimento = cdi.getSaldo() * (cdi.getCdi() / 30) * dias;
                double taxaServico = rendimento * 0.0007; 
            }}
            
          
    }
	
	
	public void simularRendimentoCia(Cliente cliente, int dias, int idProduto) {
		
		  for (Conta conta : cliente.getContas()) {
			  double rendimento = 0;
	          double taxaServico = 0;
		  
			if (conta instanceof ContaInvestimentoAutomatico) {
              
          	double taxaPorPerfil = (cliente instanceof ClientePF) ? 0.001 : 0.0015;
          	
          	Produto prod = produtoController.escolherRendaManual(idProduto);
          	
          	if(prod instanceof ProdutoRendaVariavel) {
          	ProdutoRendaVariavel prv = (ProdutoRendaVariavel) prod;
          	rendimento = prv.getRendimentoMensalEsperado();	
          	taxaServico = 0.10;
          		
          	}else if(prod instanceof ProdutoRendaFixa) {
          		ProdutoRendaFixa prf =  (ProdutoRendaFixa) prod;
              	rendimento = prf.getRedimentomensalFixo();
              	
                if (dias < 60) { 
                    System.out.println("Aviso: Investimento em carência. Taxa não aplicada."); 
                    taxaServico = 0;
                } else {
             
                    taxaServico =  rendimento * taxaPorPerfil;
                }
            }
          		
          	}
			double lucroStartup = 0.0;
			lucroStartup += taxaServico;
          System.out.println("- Conta " + conta.getNumero() + ": Rendimento R$ " + String.format("%.2f", rendimento));
          System.out.println("Lucro da VcRiquinho: R$ " + String.format("%.2f", lucroStartup)); 
      }
     
	}
	
	
	public void listarProdutosConta(String documento) {
		
		
		Conta conta = contaRepository.buscarPorDocumentoContaInvestimento(documento);
		
		if(conta instanceof ContaInvestimentoAutomatico) {
		ContaInvestimentoAutomatico cia = (ContaInvestimentoAutomatico) conta;
		System.out.println("Produtos da conta de investimento\nNúmero: " + cia.getNumero()) ;
		
		for(Produto p : cia.getProdutos()) {
			
			System.out.println("Produto: " + p.getNome());
			
		}
		}else {
			System.out.println("Tipo de conta diferente, por favor atentar-se ao numero");
		}
		
		
		
		
		
	}
	
	
	public void removerConta(String documentoCliente, String numeroConta) {
        Cliente cliente = clienteRepo.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            boolean removido = cliente.getContas().removeIf(c -> c.getNumero().equals(numeroConta));
            if (removido) {
                System.out.println("Conta removida com sucesso!");
            } else {
                System.out.println("Conta não encontrada.");
            }
        }
    }
	
	public void listarContasDoCliente(String documentoCliente) {
        Cliente cliente = clienteRepo.buscarPorDocumento(documentoCliente);
        if (cliente != null) {
            System.out.println("Contas de " + cliente.getNome() + ":");
            for (Conta c : cliente.getContas()) {
                System.out.println("- Nº: " + c.getNumero() + " | Tipo: " + c.getClass().getSimpleName());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
	

}
