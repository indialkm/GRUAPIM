package b_04_exe_03_ordemDeInsercao;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> diasSemanas = new LinkedHashSet<>();
		
		diasSemanas.add("Quarta");
		diasSemanas.add("Segunda");
		diasSemanas.add("Sexta");
		diasSemanas.add("Terça");
		diasSemanas.add("Domingo");
		diasSemanas.add("Quinta");
		diasSemanas.add("Sábado");
		
		 
		
		Iterator<String> dias = diasSemanas.iterator();

		dias.forEachRemaining(item -> System.out.println(item));

		
	}

}
