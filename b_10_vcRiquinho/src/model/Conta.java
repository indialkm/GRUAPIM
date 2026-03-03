package model;

public abstract class Conta {
	
	protected double saldo = 0.0;
    protected String numero;
    
    public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = 0.0;
	}
    
    
    
    public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}
  
    

}
