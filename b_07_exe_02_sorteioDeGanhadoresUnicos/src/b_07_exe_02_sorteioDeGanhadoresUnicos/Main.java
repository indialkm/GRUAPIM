package b_07_exe_02_sorteioDeGanhadoresUnicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.Sorteio;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> nome = new ArrayList<>();
		
		nome.add("Adriana");
		nome.add("Adriana");
		nome.add("Adriana");
		nome.add("Bia");
		nome.add("Carol");
		nome.add("Jack");
		nome.add("Alan");
		nome.add("Jack");
		nome.add("Clara");
		nome.add("Enzo");
		nome.add("Bia");
		nome.add("João");
		nome.add("Maria");
		nome.add("Luan");
		
		Sorteio sort = new Sorteio(nome);
		
		sort.gerandoSorteio();
		
		
		
		
	}

}
