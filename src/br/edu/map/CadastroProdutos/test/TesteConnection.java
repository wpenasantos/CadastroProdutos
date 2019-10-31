package br.edu.map.CadastroProdutos.test;

/**
 *
 * @author Washington
 */

import br.edu.map.CadastroProdutos.util.ConnectionFactory;

public class TesteConnection {
    public static void main(String[] args) {
        if (ConnectionFactory.getConnection() != null)
            System.out.println("Conexão bem sucedida!");
    }
}