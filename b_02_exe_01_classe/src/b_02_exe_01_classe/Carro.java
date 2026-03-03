package b_02_exe_01_classe;

public class Carro {
	
	private String marca;
	private String modelo;
	private int ano;
	
	public Carro(String marca, String modelo, int ano) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	//getters
	public String getModelo() {
		return this.modelo;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void exibirInfo()
	{
		System.out.printf(" Marca: %s \n Modelo: %s \n Ano: %d", this.marca, this.modelo, this.ano);
	}

}
