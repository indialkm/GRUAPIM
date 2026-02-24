package b_09_SistemaLanchonete.model;

import java.time.LocalDateTime;

public abstract class Prato {

	
	private static int contadorId = 0;
	

	protected int id;
	protected double precoVenda;
	protected LocalDateTime dataValidade;
	protected double peso;
	protected StatusPrato staus;
	

	public Prato(double precoVenda, LocalDateTime dataValidade, double peso, StatusPrato staus) {
		this.id = contadorId++;
		this.precoVenda = precoVenda;
		this.dataValidade = dataValidade;
		this.peso = peso;
		this.staus = staus;
	}
	
	

	public double getPrecoVenda() {
		return precoVenda;
	}



	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}



	public LocalDateTime getDataValidade() {
		return dataValidade;
	}



	public void setDataValidade(LocalDateTime dataValidade) {
		this.dataValidade = dataValidade;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public StatusPrato getStaus() {
		return staus;
	}



	public void setStaus(StatusPrato staus) {
		this.staus = staus;
	}



	public int getId() {
		return id;
	}



	public abstract double calcularPreco();
	
	@Override
	public String toString() {
	    return "ID: " + id + 
	           " | Preço: R$ " + precoVenda + 
	           " | Validade: " + dataValidade + 
	           " | Peso: " + peso + "kg";
	}
}
