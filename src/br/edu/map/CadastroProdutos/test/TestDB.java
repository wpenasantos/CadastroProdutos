/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Washington
 */

package br.edu.map.CadastroProdutos.test;
import br.edu.map.CadastroProdutos.util.ConfUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class TestDB {
    public static void main(String[] args) throws SQLException{
        
        Scanner input = new Scanner(System.in);
        
        // Obter uma conexão
        // Formato da URL: protocolo:driver_do_banco://ip:porta/nome_do_banco 
        String url = ConfUtil.getConf(ConfUtil.CONF_JDBC_URL);
        String usuario = ConfUtil.getConf(ConfUtil.CONF_JDBC_USUARIO);
        String senha = ConfUtil.getConf(ConfUtil.CONF_JDBC_SENHA);
        // obtem a guarda conexão em con
        Connection con = DriverManager.getConnection(url, usuario, senha);

        String sql = "insert into produtos (nome, preco) "
                + "values (?,?)";
        // preparar comando
        PreparedStatement st = con.prepareStatement(sql);
        // informar parametros
        System.out.println("Nome: ");
        st.setString(1, input.nextLine());
        System.out.println("Preço: ");
        st.setFloat(2, Float.parseFloat(input.nextLine()));
        
        // executar comando
        st.executeUpdate();
        
        // liberar conexão
        con.close();
    }
}
