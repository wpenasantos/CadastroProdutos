package br.edu.map.CadastroProdutos.util;

/**
 *
 * @author Washington
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/cadastroprodutos";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}
