package banco.model;

public class ContaBancaria {
	  private int numero;
	  private double saldo;
	  private boolean ativa;
	  private Cliente cliente;

	  public ContaBancaria(){
		    this.numero = 0;
		    this.cliente = null;
		    this.saldo = 0;
		    this.ativa = false;
		  }
	  
	  public ContaBancaria(int numero, Cliente cliente, double saldo){
	    this.numero = numero;
	    this.cliente = cliente;
	    this.saldo = saldo;
	    this.ativa = true;
	  }

	  public double sacar(double valor){
	    this.saldo -= valor;
	    return valor;
	  }

	  public void depositar(double valor){
	    this.saldo += valor;
	  }

	  public double getSaldo(){
	    return this.saldo;
	  }

	  public int getNumero(){
	    return this.numero;
	  }

	  public void cancelarConta(){
	    this.ativa = false;
	  }

	  public void ativarConta(){
	    this.ativa = true;
	  }

	  public boolean estadoConta(){
	    return this.ativa;
	  }

	  public Cliente getCliente() {
		return cliente;
	  }

	  public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	  }

}
