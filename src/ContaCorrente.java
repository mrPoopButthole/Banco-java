public class ContaCorrente{

  private int numero;
  private double saldo;
  private boolean ativa;
  private Cliente cliente;

  public ContaCorrente(int numero, Cliente cliente){
    this.numero = numero;
    this.setCliente(cliente);
    this.ativa = false;
    this.saldo = 0;
  }

  // public String check(){
  //   Strig cpf = this.cliente.getCpf();
  //   return cpf;
  // }
  //
  // public void dadosCliente(){
  //   this.cliente.getNome();
  //   this.cliente.getTelefone();
  //   this.cliente.getEmail();
  //   this.cliente.getCpf();
  // }

  public double sacar(double valor){
    this.saldo -= valor;
    return valor;
  }

  public double depositar(double valor){
    this.saldo += valor;
    return this.saldo;
  }

  public void transferenciaCcorrente(ContaCorrente conta_destino, double valor){
    if(saldo >= valor){
      saldo -= valor;
      conta_destino.depositar(valor);
    }
    else{
      conta_destino.depositar(0);
    }
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
