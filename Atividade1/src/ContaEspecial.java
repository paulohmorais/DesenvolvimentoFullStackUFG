
public class ContaEspecial implements Conta{

private double saldo = 0.0;

//taxa de juros aplicada, constante
public static final double I = 0.05;
	
	public void extrato() {
		System.out.println("Seu saldo : "+ saldo);
	}

	public void saque(double valor) {
		if(valor > saldo) {
			System.out.println("Operação invalida");
		}
		else {
			saldo -= valor;
			System.out.println("Valor sacado: "+ valor);
		}
		}

	public void deposito(double valor) {
		if(valor < 1) {
			System.out.println("Opera��o invalida");
		}
		else {
			saldo += valor;
			System.out.println("Valor depositado: "+ valor);
		}
		}
	public double simulaEmprestimo(double cf, int n) throws TaxaRemuneracao {

		if(cf <= 0 || n <= 0) {
			throw new TaxaRemuneracao();
		}
		else {
		return I/(1-1/Math.pow(1+I, n))*cf;
		}
		
	}
	
	public double acrescentaEmprestimo(double valor) {
		System.out.println("Valor adicionado a conta: "+ valor);
		return saldo += valor;
	}

	@Override
	public void saldo(double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nrconta(int valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cliente(String valor) {
		// TODO Auto-generated method stub
		
	}


}

//System.out.println("Simula Emprestimo: ");
//System.out.println("Credito solicitado: "+cf+" Dividido em "+n+" Meses. Juros de 5% ao m�s");
//System.out.println(n+" parcelas com valor de: "+ I/(1-1/Math.pow(1+I, n))*cf);
//System.out.println("Sua divida �: "+I/(1-1/Math.pow(1+I, n))*cf *(n));
