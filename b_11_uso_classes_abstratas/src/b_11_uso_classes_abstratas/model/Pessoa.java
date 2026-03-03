package b_11_uso_classes_abstratas.model;


public abstract class Pessoa {
	
	protected String nome;
	protected Data nascimento;
	
	
	public Pessoa() {
	}

	public Pessoa(String nome, Data nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Data getNascimento() {
		return nascimento;
	}



	public void setNascimento(Data nascimento) {
		this.nascimento = nascimento;
	}



	public abstract void imprimeDados();
}
