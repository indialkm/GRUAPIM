package teste;

import controller.ClienteCotroller;
import controller.ContaController;
import controller.ProdutoController;
import model.Cliente;
import model.Conta;
import repository.ClienteRepository;
import repository.ContaRepository;
import repository.ProdutoRepository;

public class TestePrototipo {
	
	public static void main(String[] args) {
	    	ClienteRepository clienteRepo = new ClienteRepository();
	        ProdutoRepository produtoRepo = new ProdutoRepository();
	        ContaRepository contaRepo = new ContaRepository(clienteRepo);

	        ClienteCotroller clienteCtrl = new ClienteCotroller(clienteRepo);
	        ProdutoController produtoCtrl = new ProdutoController(produtoRepo);
	        ContaController contaCtrl = new ContaController(clienteRepo, produtoCtrl, contaRepo);

	        System.out.println("=== INICIANDO TESTE AUTOMATIZADO VCRiquinho ===\n");

	        // CRUD CLIENTES ---
	        System.out.println("1. Cadastrando Clientes...");
	        clienteCtrl.cadastrar("João Silva", "joao@email.com", "12345678901"); 
	        clienteCtrl.cadastrar("Empresa Tech", "contato@tech.com", "12345678000199"); 
	        clienteCtrl.listarTodos();

	        // CRUD PRODUTOS ---
	        System.out.println("\n2. Cadastrando Produtos de Investimento...");
	        produtoCtrl.cadastrarRendaFixa("CDB 60 dias", "CDB com carência", 0.012, 60);
	        produtoCtrl.cadastrarRendaVariavel("Ações Tech", "Fundo de tecnologia", 0.025); 
	        produtoCtrl.cadastrarRendaFixa("CDB 15 dias", "CDB com carência", 0.012, 15);
	        produtoCtrl.cadastrarRendaVariavel("Ações Beleza", "Fundo de cosmetico", 0.050); 
	        produtoCtrl.cadastrarRendaFixa("CDB 180 dias", "CDB com carência", 0.012, 180);
	        produtoCtrl.cadastrarRendaVariavel("Ações Comida", "Fundo de fastFood", 0.1); 
	        produtoCtrl.listarProdutos();

	        // CRIANDO CONTAS ---
	        System.out.println("\n3. Criando Contas para os Clientes...");
	    
	        contaCtrl.criarConta("12345678901", "CC-101", 1); // Corrente
	        contaCtrl.criarConta("12345678901", "CDI-202", 2); // CDI
	        
	        contaCtrl.criarConta("12345678000199", "INV-303", 3); // Automatica
	        contaCtrl.adicionarProduto("12345678000199", "INV-303");
	        contaCtrl.adicionarProduto("12345678000199", "INV-303");
	        contaCtrl.adicionarProduto("12345678000199", "INV-303");
	        contaCtrl.adicionarProduto("12345678000199", "INV-303");
	        
	        contaCtrl.listarProdutosConta("12345678000199");
	        
	        
	        Cliente joao = clienteRepo.buscarPorDocumento("12345678901");
	        Cliente empresa = clienteRepo.buscarPorDocumento("12345678000199");
	        
	        
	        
	        for(Conta c : joao.getContas()) c.setSaldo(10000.0);
	        for(Conta c : empresa.getContas()) c.setSaldo(10000.0);

	        // --- TESTE REQUISITO 3: SIMULAÇÕES ---
	        
	        //30 dias (CDI deve cobrar 0,07%)
	        System.out.println("\n4. Simulação A: João (PF) em 30 dias");
	        contaCtrl.realizarSimulacao(joao, 30);

	        // 180 dias (Invest. Automático deve cobrar 0,15%)
	        System.out.println("\n5. Simulação B: Empresa (PJ) em 180 dias");
	        contaCtrl.realizarSimulacao(empresa, 180);

	        // Regra da CARÊNCIA (Simulando 30 dias para um produto de 60 dias)
	        System.out.println("\n6. Simulação C: Testando Carência (30 dias em produto de 60)");
	        
	        contaCtrl.realizarSimulacao(empresa, 30);

	        System.out.println("\n=== TESTE FINALIZADO COM SUCESSO ===");
	        
	    }
	
	

}
