public class ContaPoupanca{

  private int numero;
  private double saldo;
  private boolean ativa;
  private Cliente cliente;

  public ContaPoupanca(int numero, Cliente cliente){
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

  public void depositar(double valor){
    this.saldo += valor;
  }
  
  public void transferenciaCpoupanca(ContaPoupanca conta_destino, double valor){
	    if(saldo >= valor){
	      saldo -= valor;
	      conta_destino.depositar(valor);
	    }
	    else{
	      conta_destino.depositar(0);
	    }
	  }

  // public void transferenciaPoupanca(int numeroAgencia, int numeroConta, String cpf, double valor){
  //   //precisa aperfeiçoar
  //   banco.buscaAgencia(numeroAgencia).buscaCliente(cpf).buscaContaPoupanca(numeroConta).depositar(valor);
  //   if(saldo >= valor){
  //     if(banco.buscaAgencia(numeroAgencia) != null){
  //
  //     }
  //   }
  //   else{
  //     null;
  //   }
  // }

  // public void transferenciaCorrente(ContaCorrente conta_destino, double valor){
  //
  // }

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
