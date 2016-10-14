package br.com.sigo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilizada para fazer a conexão com o banco de dados.
 * 
 * @author Denis Viana
 *
 */
public class BDConfig {
	
	private static String url = "jdbc:postgresql://localhost:5432/database";  
    static String usuario = "user"
    static String senha = "senha"
		
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url,usuario,senha);
	}
	
	
	
}
