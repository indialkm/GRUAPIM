package b_09_SistemaLanchonete.controller;

import java.util.ArrayList;

import b_09_SistemaLanchonete.model.Prato;

public class PratoController {
	
	private ArrayList<Prato> lista = new ArrayList<>();
	
	public void adicionarAoCardapio(Prato prato) {
        lista.add(prato); 
        System.out.println("Adicionado: " + prato.getClass().getSimpleName());
    }
	
	public void exibirPratos()
	{
		System.out.println("Lista de todos os pratos pedidos\n");
		for(Prato p : this.lista) {
			System.out.println(p);
			
		}
	}

}
