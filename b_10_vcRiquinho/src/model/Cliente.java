package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	private String nome;
	private String email;
	private String documento;
	private List<Conta> contas = new ArrayList<>();
	
	public Cliente(String nome, String email, String documento) {
		this.nome = nome;
		this.email = email;
		this.documento = documento.replaceAll("[^0-9]", "");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
	    this.documento = documento ;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public abstract double getTaxaServico();
	
}
