package controller;

import model.ClientePF;
import model.ClientePJ;
import repository.ClienteRepository;

public class ClienteCotroller {
	
	private ClienteRepository repository;

	public ClienteCotroller(ClienteRepository repository) {
		this.repository = repository;
	}

	public void cadastrar(String nome, String email, String documento) {
        
        if (documento.length() == 11) {
            ClientePF pf = new ClientePF(nome, email, documento);
            repository.adicionar(pf);
            System.out.println("Pessoa Física cadastrada!");
        } else if (documento.length() == 14) {
            ClientePJ pj = new ClientePJ(nome, email, documento);
            repository.adicionar(pj);
            System.out.println("Pessoa Jurídica cadastrada!");
        } else {
            System.out.println("Erro: Documento inválido.");
        }
    }
	
	public void listarTodos() {
        repository.listarTodos().forEach(c -> 
            System.out.println(c.getNome() + " - " + c.getDocumento() + " [" + c.getClass().getSimpleName() + "]")
        );
    }
	
	public void remover(String documento) {
        boolean conseguiuRemover = repository.remover(documento);
        
        if (conseguiuRemover) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Erro: Cliente não encontrado para remoção.");
        }
    }
	
	public void atualizar(String documentoAntigo, String novoNome, String novoEmail) {
        
        model.Cliente clienteExistente = repository.buscarPorDocumento(documentoAntigo);

        if (clienteExistente != null) {
          
            clienteExistente.setNome(novoNome);
            clienteExistente.setEmail(novoEmail);
            
            repository.atualizar(documentoAntigo, clienteExistente);
            System.out.println("Dados do cliente atualizados com sucesso!");
        } else {
            System.out.println("Erro: Cliente não encontrado para atualização.");
        }
	
	

	}
	
}
