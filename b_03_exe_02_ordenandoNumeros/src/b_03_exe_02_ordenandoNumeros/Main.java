package b_03_exe_02_ordenandoNumeros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<>();
		
		Random rand = new Random();
		
		for(int i = 0; i <= 9; i++)
		{
			int sort = rand.nextInt(120);
			list.add(i, sort);
			
		}
		
		System.out.println("Lista desordenada");
		list.forEach(item-> System.out.printf("%d ", item));
		
		list.sort(null);
		
		System.out.println("\nLista ordenada");
		list.forEach(item-> System.out.printf("%d ", item));

	}

}
