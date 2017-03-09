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
	
	private static String url = "jdbc:postgresql://pgres-sigo.c3xuf7uapyec.us-east-1.rds.amazonaws.com:5433/sigo";  
    static String usuario = "sigodb";
    static String senha = "sigoUndb2017";
		
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		System.out.println("Conectado no banco...");
		return DriverManager.getConnection(url,usuario,senha);
	}
	
}
