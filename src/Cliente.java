public class Cliente{

  private String nome;
  private String telefone;
  private String email;
  private String cpf;
  private String senha;
  private ContaCorrente[] contasC;
  private ContaPoupanca[] contasP;

  public Cliente(String nome, String telefone, String email, String cpf, String senha){
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.cpf = cpf;
    this.senha = senha;
    this.contasC = new ContaCorrente[5];
    this.contasP = new ContaPoupanca[5];
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }

  public String getNome(){
    return this.nome;
  }

  public String getTelefone(){
    return this.telefone;
  }

  public String getEmail(){
    return this.email;
  }

  public String getCpf(){
    return this.cpf;
  }

  public String getSenha(){
    return this.senha;
  }

  public void setContaCorrente(ContaCorrente conta){
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

  public ContaCorrente[] getContasCorrente(){
    return contasC;
  }

  public ContaCorrente buscaContaCorrente(int numero){
    int i = 0;
    while(contasC[i] != null){
      if(contasC[i].getNumero() == numero){
        return contasC[i];
      }
      i++;
    }
    return null;
  }

  public void setContaPoupanca(ContaPoupanca conta){
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

  public ContaPoupanca[] getContasPoupanca(){
    return contasP;
  }

  public ContaPoupanca buscaContaPoupanca(int numero){
    int i = 0;
    while(contasP[i] != null){
      if(contasP[i].getNumero() == numero){
        return contasP[i];
      }
      i++;
    }
    return null;
  }

}
