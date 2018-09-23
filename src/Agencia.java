public class Agencia{
  private Cliente[] clientes;
  private ContaPoupanca[] contasP;
  private ContaCorrente[] contasC;
  private Funcionario[] funcionarios;
  private int numeroAgencia;


  public Agencia(int numeroAgencia){
    this.numeroAgencia = numeroAgencia;
    this.clientes = new Cliente[100];
    this.contasC = new ContaCorrente[500];
    this.contasP = new ContaPoupanca[500];
    this.funcionarios = new Funcionario[40];
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

  public void adicionarContaPoupanca(ContaPoupanca conta){
    for(int i = 0; i < contasP.length; i++){
      if(contasP[i] == null){
        contasP[i] = conta;
        break;
      }
      else{
        continue;
      }
    }
  }

  public void adicionarContaCorrente(ContaCorrente conta){
    for(int i = 0; i < contasC.length; i++){
      if(contasC[i] == null){
        contasC[i] = conta;
        break;
      }
      else{
        continue;
      }
    }
  }

    public void adicionarFuncionario(Funcionario funcionario){
      for(int i = 0; i < funcionarios.length; i++){
        if(funcionarios[i] == null){
          funcionarios[i] = funcionario;
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

  // public void removerContaPoupanca(String cpf, int numero){
  //   for(int i = 0; i < clientes.length; i++){
  //     if(clientes[i].getCpf().equals(cpf)){
  //       ContaPoupanca aux = new ContaPoupanca[5];
  //       aux = clientes[i].getContasPoupanca();
  //       for(int j = 0; j < aux.length; j++){
  //         if(numero == aux[i].getNumero()){
  //           aux[i] = null;
  //           break;
  //         }
  //         else{
  //           continue;
  //         }
  //       }
  //       clientes[i].getContasPoupanca() = aux;
  //       break;
  //     }
  //   }
  // }

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
    for(int i = 0; i < contasP.length; i++){
      if(contasP[i] == null){
        continue;
      }
      else{
        saldo_total += contasP[i].getSaldo();
      }
    }
    for(int i = 0; i < contasC.length; i++){
      if(contasC[i] == null){
        continue;
      }
      else{
        saldo_total += contasC[i].getSaldo();
      }
    }
    return saldo_total;
  }

}
