package b_04_exe_05__objetosPersonalizados.model;

public class Produto implements Comparable<Object>{
	
	private String nome;
	private double preco;
	
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		Produto outro = (Produto) o;
		return Double.compare(this.preco, outro.preco);
		
	}
	

}
