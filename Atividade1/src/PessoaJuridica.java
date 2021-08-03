
public class PessoaJuridica extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeResponsavel;
	
	public PessoaJuridica (String nome, String nomeResponsavel, Conta conta, int cnpj, String atividade){
		super(nome,conta);
		this.nomeResponsavel = nomeResponsavel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void exibeIdentificacao() {
		System.out.println(getCodigo()+" - "+getNome()+" - "+getNomeResponsavel()+" - "+getConta());
		System.out.println("=================================================================");
		}
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
}
