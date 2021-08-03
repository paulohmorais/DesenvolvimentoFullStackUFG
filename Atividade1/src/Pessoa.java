import java.io.Serializable;

public abstract class Pessoa implements Serializable {

	private static int proxCod=1;
	private Conta conta;
	private String nome;
	private int codigo;
	
	// construtor
	public Pessoa(String nome,Conta conta) {
		this.codigo = getProxCod();
		this.nome = nome;
		this.conta = conta;
	}
	
	public abstract void exibeIdentificacao();
	
	public int getProxCod() {
		return proxCod++;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void exibeMenu() {
		
	}
}
