package b_11_uso_classes_abstratas.model;


public class Gerente extends Funcionario {

	private String area;

	public Gerente(String nome, Data nascimento, float salario, String area) {
		super(nome, nascimento, salario);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public float calcularImposto() {
		// TODO Auto-generated method stub
		return this.salario * 0.5f;
	}

	public void imprimeDados() {
		// TODO Auto-generated method stub
		System.out.println("Cliente: " + this.nome + "\n"
					     + "Data de nascimento: " + this.nascimento.exibirData() + "\n"
					     + "Sálario: " + this.salario + "\n"
						  );		
		
		
	}

	
	
}
