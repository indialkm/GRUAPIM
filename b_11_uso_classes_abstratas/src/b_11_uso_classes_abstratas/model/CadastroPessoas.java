package b_11_uso_classes_abstratas.model;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
	
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public CadastroPessoas() {
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void cadastrarPessoas(List<Pessoa> pessoas) {
		for(Pessoa pess : pessoas) {
			this.pessoas.add(pess);
		}
	}
	
	public void imprimeCadastro() {
		System.out.println("Pessoas cadastradas\n");
		if(this.pessoas != null) {
		this.pessoas.forEach(item -> item.imprimeDados());
		}else {
			System.out.println("A lista está vazia");
		}
	}
	
	
	

}
