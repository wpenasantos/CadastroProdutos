package br.edu.map.CadastroProdutos.dao;

import br.edu.map.CadastroProdutos.model.Especificacao;
import br.edu.map.CadastroProdutos.model.Produto;
import br.edu.map.CadastroProdutos.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Washington
 */

public class ProdutoDAO {
    private Connection con;
    private String sql;
    private PreparedStatement st;
    private ResultSet rs;

    public void inserir(Produto produto) throws Exception {
        con = ConnectionFactory.getConnection();

        // inserir especificação
        sql = "insert into especificacoes(fabricante, cor, sistema, detalhes) values (?,?,?,?)";

        // informa ao jdbc que o codigo gerado deverá ser retornado
        st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        st.setString(1, produto.getEspecificacao().getFabricante());
        st.setString(2, produto.getEspecificacao().getCor());
        st.setString(3, produto.getEspecificacao().getSistema());
        st.setString(4, produto.getEspecificacao().getDetalhes());

        st.executeUpdate();

        rs = st.getGeneratedKeys();

        int codigoEspecificacao = 0;

        if (rs.next()) {
            codigoEspecificacao = rs.getInt(1);
        }
        
        // recuperar código gerado
        sql = "insert into produtos(nome, preco, especificacao) values (?,?,?)";

        st = con.prepareStatement(sql);

        st.setString(1, produto.getNome());
        st.setDouble(2, produto.getPreco());
        st.setInt(3, codigoEspecificacao);

        st.executeUpdate();

        con.close();
    }

    public List<Produto> listar() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        sql = "select p.*, e.* from produtos p, especificacoes e where p.especificacao = e.codigo";
        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setEspecificacao(new Especificacao());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getFloat("preco"));

            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));

            produtos.add(p);
        }
        con.close();
        return produtos;
    }

    public Produto buscar(int codigo) throws Exception {
        Produto p = null;
        con = ConnectionFactory.getConnection();
        sql = "select p.*, e.* from produtos p, especificacoes e where p.codigo = ? and p.especificacao = e.codigo";
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            p = new Produto();
            p.setEspecificacao(new Especificacao());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getInt("preco"));

            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));
        }
        con.close();
        return p;
    }

    public void remover(Produto produto) throws Exception {
        con = ConnectionFactory.getConnection();
        
        sql = "delete from especificacoes where codigo = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, produto.getEspecificacao().getCodigo());
        st.executeUpdate();
        
        sql = "delete from produtos where codigo = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, produto.getCodigo());     
        st.executeUpdate();

        con.close();
    }

    public void editar(Produto produto) throws Exception{
        con = ConnectionFactory.getConnection();

        sql = "update produtos set nome = ?, preco = ? where codigo = ?";

        st = con.prepareStatement(sql);

        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, produto.getCodigo());

        st.executeUpdate();

        sql = "update especificacoes set fabricante = ?, cor = ?, sistema = ?, detalhes = ? where codigo = ?";

        st = con.prepareStatement(sql);

        st.setString(1, produto.getEspecificacao().getFabricante());
        st.setString(2, produto.getEspecificacao().getCor());
        st.setString(3, produto.getEspecificacao().getSistema());
        st.setString(4, produto.getEspecificacao().getDetalhes());
        st.setInt(5, produto.getEspecificacao().getCodigo());
        st.executeUpdate();

        con.close();
    }
}