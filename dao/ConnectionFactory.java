package estacio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

private String url = "jdbc:derby://localhost:1527/bancoExemplo";
private String usuario = "estacio";
private String senha = "123";
private String driver = "org.apache.derby.jdbc.ClientDriver";

public Connection getConnection() throws ClassNotFoundException{
    Class.forName(driver);
        try{
            return DriverManager.getConnection(url, usuario, senha);
    }catch (SQLException e) {
        throw new RuntimeException(e); 
    }
}
                
}
