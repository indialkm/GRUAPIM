package b_11_uso_classes_abstratas.model;


public class Cliente extends Pessoa {

	private int codigo;

	public Cliente(String nome, Data nascimento, int codigo) {
		super(nome, nascimento);
		this.codigo = codigo;
	}

	@Override
	public void imprimeDados() {
		// TODO Auto-generated method stub
		System.out.println("Código: " + this.codigo+ "\n"
					     + "Cliente: " + this.nome + "\n"
					     + "Data de nascimento: " + this.nascimento.exibirData() + "\n"
						  );			
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	

}
