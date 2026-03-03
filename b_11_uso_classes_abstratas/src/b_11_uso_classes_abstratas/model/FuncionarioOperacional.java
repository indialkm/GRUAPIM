package b_11_uso_classes_abstratas.model;

public class FuncionarioOperacional extends Funcionario {

	public FuncionarioOperacional(String nome, Data nascimento, float salario) {
		super(nome, nascimento, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getSalario() {
		// TODO Auto-generated method stub
		return super.getSalario();
	}

	@Override
	public void setSalario(float salario) {
		// TODO Auto-generated method stub
		super.setSalario(salario);
	}

	@Override
	public float calcularImposto() {
		// TODO Auto-generated method stub
		return super.calcularImposto();
	}

	@Override
	public void imprimeDados() {
		// TODO Auto-generated method stub
		super.imprimeDados();
	}


}
