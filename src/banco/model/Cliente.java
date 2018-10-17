package banco.model;

public class Cliente {
	private String nome;
	  private String telefone;
	  private String email;
	  private String cpf;
	  private String senha;
	  private ContaBancaria[] contas;
	  
	  public Cliente(){
		    this.nome = "";
		    this.telefone = "";
		    this.email = "";
		    this.cpf = "";
		    this.senha = "";
		    this.contas = new ContaBancaria[10];
		  }

	  public Cliente(String nome, String telefone, String email, String cpf, String senha){
	    this.nome = nome;
	    this.telefone = telefone;
	    this.email = email;
	    this.cpf = cpf;
	    this.senha = senha;
	    this.contas = new ContaBancaria[10];
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

	  public void setConta(ContaBancaria conta){
	    for(int i = 0; i < contas.length; i++){
	      if(contas[i] == null){
	        contas[i] = conta;
	        break;
	      }
	    }
	  }

	  public ContaBancaria[] getContasCorrente(){
	    return contas;
	  }

	  public ContaBancaria buscaConta(int numero){
	    int i = 0;
	    while(contas[i] != null){
	      if(contas[i].getNumero() == numero){
	        return contas[i];
	      }
	      i++;
	    }
	    return null;
	  }
}
