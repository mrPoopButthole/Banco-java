public class Funcionario{

  private String loginFuncionario;
  private String senhaFuncionario;

  public Funcionario(String loginFuncionario, String senhaFuncionario){
    this.loginFuncionario = loginFuncionario;
    this.senhaFuncionario = senhaFuncionario;
  }

  public void setLoginFuncionario(String login){
    loginFuncionario = login;
  }

  public void setSenhaFuncionario(String senha){
    senhaFuncionario = senha;
  }

  public String getLoginFuncionario(){
    return loginFuncionario;
  }

  public String getSenhaFuncionario(){
    return senhaFuncionario;
  }
}
