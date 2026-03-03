package b_02_exe_4_excecaoPersonalizada.model;

import b_02_exe_4_excecaoPersonalizada.excecoes.SaqueInsuficienteException;

public class ContaBancaria {
	
	private String numeroConta;
	private String usuario;
	private double saldo;
	
	public ContaBancaria(String numeroConta, String usuario, double saldo) {
		this.numeroConta = numeroConta;
		this.usuario = usuario;
		this.saldo = saldo;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public double getValor() {
		return saldo;
	}

	public void sacar(double saque)
	{
		if(this.saldo - saque == 0 || this.saldo - saque < 0 ) {
		throw new SaqueInsuficienteException("\nOlá "+ this.usuario + "!\n" +"O valor na conta é insuficiente para a operação do saque\nSaldo atual: "+ this.saldo);
		};
		
		this.saldo = saldo - saque;
		System.out.println("\nOlá "+ this.usuario + "!\n" + "Saque concluido com sucesso\nSaldo atual: "+ this.saldo);
	}
	
	public void depositar(double deposito)
	{
		this.saldo = saldo + deposito;
		System.out.println("\nOlá "+ this.usuario + "!\n" + "Depósito concluido com sucesso\nSaldo atual: "+ this.saldo);
	}
	
	
	

}
