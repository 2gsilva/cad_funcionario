package estacio.negocio;

public class Funcionario {
    private String matricula, nome, login, senha;
    private double salarioBruto;

    public Funcionario(){}
           
    public String getMatricula(){
    return matricula;}
    
    public void setMatricula(String matricula){
    this.matricula = matricula; }
    
    public String getNome(){
    return nome;}
    
    public void setNome(String nome){
    this.nome = nome;}
    
     public String getLogin(){
    return login;}
    
    public void setLogin(String login){
    this.login = login;}
    
     public String getSenha(){
    return senha;}
    
    public void setSenha(String senha){
    this.senha = senha;}
    
    public double getSalarioBruto(){
    return salarioBruto;}
    
    public void setSalarioBruto(double salarioBruto){
    this.salarioBruto = salarioBruto;}
    
    public double getSalarioLiquido(){
    return salarioBruto * 0.89;}
    
}
