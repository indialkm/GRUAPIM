package controller;

import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaCDI;
import model.ContaCorrente;
import model.ContaInvestimentoAutomatico;
import repository.ClienteRepository;

public class ContaController {
	
	private ClienteRepository clienteRepo;

    public ContaController(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
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
            }
        } else {
            System.out.println("Erro: Cliente não encontrado!");
        }
    }
	
	
	
	public void realizarSimulacao(Cliente cliente, int dias) {
        double lucroStartup = 0;
        System.out.println("Simulação para " + cliente.getNome() + " em " + dias + " dias:");

        for (Conta conta : cliente.getContas()) {
            double rendimento = 0;
            double taxaServico = 0;

            
            if (conta instanceof ContaCorrente) {
                rendimento = 0;
            } 
            
            else if (conta instanceof ContaCDI) {
            	ContaCDI cdi = (ContaCDI) conta;
                rendimento = cdi.getSaldo() * (cdi.getCdi() / 30) * dias;
                taxaServico = rendimento * 0.0007; 
            }
            
            else if (conta instanceof ContaInvestimentoAutomatico) {
               
            	double taxaPorPerfil = (cliente instanceof ClientePF) ? 0.001 : 0.0015;
                taxaServico = rendimento * taxaPorPerfil;
                
                if (dias < 60) { 
                    System.out.println("Aviso: Investimento em carência. Taxa não aplicada."); 
                    taxaServico = 0;
                } else {
                    taxaServico = rendimento * cliente.getTaxaServico();
                }
            }

            lucroStartup += taxaServico;
            System.out.println("- Conta " + conta.getNumero() + ": Rendimento R$ " + String.format("%.2f", rendimento));
        }
        System.out.println("Lucro da VcRiquinho: R$ " + String.format("%.2f", lucroStartup)); 
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
