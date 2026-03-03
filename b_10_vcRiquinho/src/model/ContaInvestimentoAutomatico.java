package model;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta {
	
	private List<Produto> produtos = new ArrayList<>();

	public ContaInvestimentoAutomatico(String numero, double saldo) {
		super(numero, saldo);
		// TODO Auto-generated constructor stub
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionar(Produto prod) {
		produtos.add(prod);
	}

}
