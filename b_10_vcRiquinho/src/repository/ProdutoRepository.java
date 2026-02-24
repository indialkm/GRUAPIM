package repository;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoRepository {
	
	private List<Produto> produtos = new ArrayList<>();
	
	// CRIA
	public void adicionar(Produto produto) {
		
		produtos.add(produto);
		
	}
	
	// BUSCAR TODOS
	public List<Produto> listarTodos() {
        return produtos;
    }

	// BUSCAR POR NOME
	public Produto buscarPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
	
	//REMOVER
	public boolean remover(String nome) {
        Produto p = buscarPorNome(nome);
        if (p != null) {
            return produtos.remove(p);
        }
        return false;
    }
	
	//ATUALIZAR
	public boolean atualizar(String nomeOriginal, Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
         
            if (produtos.get(i).getNome().equalsIgnoreCase(nomeOriginal)) {
              
                produtos.set(i, produtoAtualizado);
                return true;
            }
        }
        return false;
    }
}
