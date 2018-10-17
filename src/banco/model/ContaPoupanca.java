package banco.model;

public class ContaPoupanca extends ContaBancaria {
	
	public ContaPoupanca(int numero, Cliente cliente, double saldo) {
		super(numero, cliente, saldo);
	}
	
	public void transferenciaCpoupanca(ContaPoupanca conta_destino, double valor) {
		 if(super.getSaldo() >= valor){
		      super.sacar(valor);
		      conta_destino.depositar(valor);
		    }
		 else{
		      conta_destino.depositar(0);
		 }
	}
}
