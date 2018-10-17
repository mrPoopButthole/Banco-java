package banco.model;

public class ContaCorrente extends ContaBancaria {
	private double limite = 5000;
	
	public ContaCorrente(int numero, Cliente cliente, double saldo) {
		super(numero, cliente, saldo);
	}
	
	public void transferencia(ContaCorrente conta_destino, double valor) {
		 if(super.getSaldo() >= valor && super.getSaldo() <= limite){
		      super.sacar(valor);
		      conta_destino.depositar(valor);
		    }
		 else{
		      conta_destino.depositar(0);
		 }
	}
}
