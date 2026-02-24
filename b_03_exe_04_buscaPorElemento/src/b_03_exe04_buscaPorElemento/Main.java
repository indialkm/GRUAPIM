package b_03_exe04_buscaPorElemento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import b_03_exe04_buscaPorElemento.excecoes.CidadeNaoEncontradaException;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listCidades = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
	
		listCidades.add("São Paulo");
		listCidades.add("Rio de Janeiro");
		listCidades.add("Guarulhos");
		listCidades.add("Montes Claros");
		
		System.out.println("Digite o nome de uma cidade");
		String resposta = scan.nextLine();

		
			if(listCidades.contains(resposta) != true) {
				throw new  CidadeNaoEncontradaException("Cidade não encontrada na lista");
			}
		
			int index = listCidades.contains(resposta) ? listCidades.indexOf(resposta) : 0;
			System.out.println("A cidade " + listCidades.get(index) + " está no índice " + index);
			
			scan.close();
	}

}
