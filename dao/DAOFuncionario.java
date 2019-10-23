package estacio.dao;


import estacio.negocio.Funcionario;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOFuncionario {
private Connection con = null;
private PreparedStatement pst = null;
private ResultSet rs = null;

public DAOFuncionario() throws Exception{

   // Class.forName("org.apache.derby.jdbc.ClientDriver");
    con = new ConnectionFactory().getConnection();
}

public void incluir(Funcionario funcionario) throws Exception{
pst = con.prepareStatement("insert into funcionario values(?,?,?)");
pst.setString(1, funcionario.getMatricula());
pst.setString(2, funcionario.getNome());
pst.setDouble(3, funcionario.getSalarioBruto());
pst.execute();
pst.close();
}

public Funcionario consultar(Funcionario funcionario) throws Exception{

    Funcionario func = null;
    pst = con.prepareStatement("select * from funcionario where matricula = ?");
    pst.setString(1, funcionario.getMatricula());
    rs = pst.executeQuery();
    
    if(rs.next()){
            func = new Funcionario();
    func.setMatricula(rs.getString("matricula"));
    func.setNome(rs.getString("nome"));
    func.setSalarioBruto(Double.parseDouble( rs.getString("salariobruto")));
    }
    
    pst.close();
    rs.close();
    
    return func;}

public Funcionario autenticar(Funcionario funcionario) throws Exception{

    Funcionario func = null;
    pst = con.prepareStatement("select * from loginsenha where login = ?");
    pst.setString(1, funcionario.getLogin());
    rs = pst.executeQuery();
    
    if(rs.next()){
            func = new Funcionario();
    func.setLogin(rs.getString("login"));
    func.setSenha(rs.getString("senha"));
        }
    
    pst.close();
    rs.close();
    
    return func;}

}