
public class PessoaFisica extends Pessoa {
	
	public PessoaFisica(String nome, Conta conta, int cpf, int dtNascimento, String genero ){
		super(nome,conta);
	}

	public void exibeIdentificacao() {
	System.out.println(getCodigo()+" - "+getNome()+" - "+getConta());
	System.out.println("=================================================================");
	}

}

   