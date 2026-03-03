package b_04_exe_04_nomeOrdemAlfabetica;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set <String> nomes = new TreeSet<>();
		
		nomes.add("Luana");
		nomes.add("Alice");
		nomes.add("Bernardo");
		nomes.add("João");
		nomes.add("Maria");
		
		nomes.forEach(nome -> System.out.println("\nNome: " + nome));

	}

}
