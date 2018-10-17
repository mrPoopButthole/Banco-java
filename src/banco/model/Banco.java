package banco.model;

public class Banco {
	  private Agencia[] agencias;
	  private Funcionario[] funcionarios;
	  
	  public Banco(){
	    this.agencias = new Agencia[100];
	    this.funcionarios = new Funcionario[1000];
	  }

	  public void adicionarAgencia(Agencia agencia){
	    for(int i = 0; i < agencias.length; i++){
	      if(agencias[i] == null){
	        agencias[i] = agencia;
	        break;
	      }
	      else{
	        continue;
	      }
	    }
	  }

	  public Agencia buscaAgencia(int numero){
	    for(int i = 0; i < agencias.length; i++){
	      if(agencias[i].getNumeroAgencia() == numero){
	        return agencias[i];
	      }
	      else{
	        continue;
	      }
	    }
	    return null;
	  }
	  
	  public void adicionarFuncionario(Funcionario funcionario){
		    for(int i = 0; i < funcionarios.length; i++){
		      if(funcionarios[i] == null){
		        funcionarios[i] = funcionario;
		        break;
		      }
		    }
	 }
	  
}
