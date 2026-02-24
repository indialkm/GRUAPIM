package b_04_exe_05__objetosPersonalizados;

import java.util.Set;
import java.util.TreeSet;

import b_04_exe_05__objetosPersonalizados.model.Produto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Produto> carrinho = new TreeSet<>();

		Produto pro1 = new Produto("Fralda", 89.90);
		Produto pro2 = new Produto("Lencinho", 9.90);
		Produto pro3 = new Produto("Mamadeira", 25.00);
		Produto pro4 = new Produto("Leite", 110.90);
		Produto pro5 = new Produto("Maça", 17.60);
		Produto pro6 = new Produto("Banana", 22.50);
		Produto pro7 = new Produto("Naninha", 75.69);
	
		carrinho.add(pro1);
		carrinho.add(pro2);
		carrinho.add(pro3);
		carrinho.add(pro4);
		carrinho.add(pro5);
		carrinho.add(pro6);
		carrinho.add(pro7);
		
		System.out.println("****Carrinho****");
		carrinho.forEach(item->System.out.println("Nome: " + item.getNome() + " Preço: " + item.getPreco()));
		
		
	}

}
