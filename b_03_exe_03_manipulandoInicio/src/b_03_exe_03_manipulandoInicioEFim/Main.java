package b_03_exe_03_manipulandoInicioEFim;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> fila = new LinkedList<>();

       
        fila.addLast("Ana");
        fila.addLast("Bruno");
        fila.addLast("Carla");
        fila.addLast("Daniel");
        fila.addLast("Eduarda");

        System.out.println("Fila inicial: " + fila);

       
        fila.removeFirst();
        fila.removeFirst();

        System.out.println("Fila após atender os 2 primeiros: " + fila);

        
        fila.addFirst("Roberto (Prioritário)");
        fila.addFirst("Sônia (Prioritária)");

        
        System.out.println("Ordem final da fila:");
        for (String cliente : fila) {
            System.out.println("- " + cliente);
        }
    }

	}

