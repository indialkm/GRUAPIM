package b_04_exe01_removendoDuplicatas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> lista = new ArrayList<>();
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			int sort = rand.nextInt(5);
			lista.add(i,sort);
		}
		
		System.out.println("***Lista com repetições**");
		lista.forEach(item -> System.out.printf("%d ", item));
		
		
		Set<Integer> novaColecao = new HashSet<>();
		novaColecao.addAll(lista);
		
		System.out.println("\n\n***Lista sem repetições**");
		novaColecao.forEach(item -> System.out.printf("%d ", item));
	}

}
