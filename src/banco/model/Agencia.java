package banco.model;

public class Agencia {
	private Cliente[] clientes;
	  private ContaBancaria[] contas;
	  private int numeroAgencia;

	  public Agencia(){
		    this.numeroAgencia = 0;
		    this.clientes = new Cliente[100];
		    this.contas = new ContaBancaria[1000];
	  }
	  
	  public Agencia(int numeroAgencia){
	    this.numeroAgencia = numeroAgencia;
	    this.clientes = new Cliente[100];
	    this.contas = new ContaBancaria[1000];
	  }

	  public void adicionarCliente(Cliente cliente){ //adicionar um cliente a um array de clientes.
	    for(int i = 0; i < clientes.length; i++){
	      if(clientes[i] == null){
	        clientes[i] = cliente;
	        break;
	      }
	      else{
	        continue;
	      }
	    }
	  }

	  public void adicionarConta(ContaBancaria conta){
	    for(int i = 0; i < contas.length; i++){
	      if(contas[i] == null){
	        contas[i] = conta;
	        break;
	      }
	      else{
	        continue;
	      }
	    }
	  }


	  public int getNumeroAgencia(){
	     return numeroAgencia;
	  }


	  public Cliente buscaCliente(String cpf){
	    for(int i = 0; i < clientes.length; i++){
	      if(clientes[i] != null && clientes[i].getCpf().equals(cpf)){
	        return clientes[i];
	      }
	    }
	    return null;
	  }

	  public double getSaldoAgencia(){
	    double saldo_total = 0;
	    for(int i = 0; i < contas.length; i++){
	      if(contas[i] == null){
	        continue;
	      }
	      else{
	        saldo_total += contas[i].getSaldo();
	      }
	    }
	    for(int i = 0; i < contas.length; i++){
	      if(contas[i] == null){
	        continue;
	      }
	      else{
	        saldo_total += contas[i].getSaldo();
	      }
	    }
	    return saldo_total;
	  }
}
