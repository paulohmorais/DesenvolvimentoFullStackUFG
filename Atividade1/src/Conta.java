import java.io.Serializable;

public interface Conta extends Serializable {
	
	public void extrato();
	public void saque (double valor);
	public void deposito (double valor);
	public void saldo (double valor);
	public void nrconta (int valor);
	public void cliente (String valor);
	
	//metodos  cf = capital financiado n = meses
	public double simulaEmprestimo(double cf,int nrconta);
	
	public double acrescentaEmprestimo(double valor);
	
}
