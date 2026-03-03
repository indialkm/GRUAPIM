package b_11_uso_classes_abstratas;

import java.util.ArrayList;
import java.util.List;

import b_11_uso_classes_abstratas.model.CadastroPessoas;
import b_11_uso_classes_abstratas.model.Cliente;
import b_11_uso_classes_abstratas.model.Data;
import b_11_uso_classes_abstratas.model.FuncionarioOperacional;
import b_11_uso_classes_abstratas.model.Gerente;
import b_11_uso_classes_abstratas.model.Pessoa;

public class TestaCadastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.add(new Cliente("Clarice", new Data(25, 4, 1989), 1));
		pessoas.add(new FuncionarioOperacional("Maria", new Data(25, 4, 1989), 1250.00f));
		pessoas.add(new Gerente("Joao", new Data(1, 2, 1997), 1250.00f, "Vendas"));
		
		CadastroPessoas cad = new CadastroPessoas();
		cad.cadastrarPessoas(pessoas);
		cad.imprimeCadastro();
		

	}

}
