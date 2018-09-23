public class Banco{

  private Agencia[] agencias;

  public Banco(){
    this.agencias = new Agencia[100];
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

}
