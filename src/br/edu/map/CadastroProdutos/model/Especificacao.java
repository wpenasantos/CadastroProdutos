package br.edu.map.CadastroProdutos.model;

/**
 *
 * @author Washington
 */

public class Especificacao {
    private int codigo;
    private String fabricante;
    private String cor;
    private String sistema;
    private String detalhes;

    public Especificacao(int codigo, String nome, String fabricante, String cor, String sistema, String detalhes) {
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.sistema = sistema;
        this.detalhes = detalhes;
    }

    public Especificacao() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" | ");
        sb.append(codigo)
                .append(" | ").append(fabricante)
                .append(" | ").append(cor)
                .append(" | ").append(sistema)
                .append(" | ").append(detalhes)
                .append(" | ");
        return sb.toString();
    }
}
