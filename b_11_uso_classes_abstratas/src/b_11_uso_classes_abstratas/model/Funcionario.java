package b_11_uso_classes_abstratas.model;


public abstract class Funcionario extends Pessoa {

	protected float salario;

	public Funcionario(String nome, Data nascimento, float salario) {
		super(nome, nascimento);
		this.salario = salario ;
		float imposto = calcularImposto();
		this.salario = salario - imposto;

	}

	

	public float getSalario() {
		return salario;
	}



	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float calcularImposto() {
		
		return this.salario * 0.3f; 
		
	}

	public void imprimeDados() {
		// TODO Auto-generated method stub
		System.out.println("Cliente: " + this.nome + "\n"
					     + "Data de nascimento: " + this.nascimento.exibirData() + "\n"
					     + "Sálario: " + this.salario + "\n"
						  );			
		
	}

}
