package controller;

import model.Produto;
import model.ProdutoRendaFixa;
import model.ProdutoRendaVariavel;
import repository.ProdutoRepository;

public class ProdutoController {
	
	private ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    
    public void cadastrarRendaFixa(String nome, String desc, double taxa, int carencia) {
        ProdutoRendaFixa rf = new ProdutoRendaFixa(nome, desc, taxa, carencia);
        repository.adicionar(rf);
        System.out.println("Sucesso: Produto Renda Fixa cadastrado!");
    }

    public void cadastrarRendaVariavel(String nome, String desc, double taxaEsperada) {
        ProdutoRendaVariavel rv = new ProdutoRendaVariavel(nome, desc, taxaEsperada);
        repository.adicionar(rv);
        System.out.println("Sucesso: Produto Renda Variável cadastrado!");
    }

    
    public void listarProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS DISPONÍVEIS ---");
        for (Produto p : repository.listarTodos()) {
            String tipo = (p instanceof ProdutoRendaFixa) ? "Renda Fixa" : "Renda Variável";
            System.out.println("Nome: " + p.getNome() + " | Tipo: " + tipo + " | Desc: " + p.getDescricao());
        }
    }

    
    public void atualizarDescricao(String nome, String novaDesc) {
        Produto p = repository.buscarPorNome(nome);
        if (p != null) {
            p.setDescricao(novaDesc);
            System.out.println("Descrição atualizada!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

    
    public void remover(String nome) {
        boolean removido = repository.remover(nome);
        if (removido) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado.");
        }
    }

}
