package br.edu.map.CadastroProdutos.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Washington
 */

@Entity
@Table(name = "especificacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especificacoes.findAll", query = "SELECT e FROM Especificacoes e")
    , @NamedQuery(name = "Especificacoes.findByCodigo", query = "SELECT e FROM Especificacoes e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Especificacoes.findByFabricante", query = "SELECT e FROM Especificacoes e WHERE e.fabricante = :fabricante")
    , @NamedQuery(name = "Especificacoes.findByCor", query = "SELECT e FROM Especificacoes e WHERE e.cor = :cor")
    , @NamedQuery(name = "Especificacoes.findBySistema", query = "SELECT e FROM Especificacoes e WHERE e.sistema = :sistema")
    , @NamedQuery(name = "Especificacoes.findByDetalhes", query = "SELECT e FROM Especificacoes e WHERE e.detalhes = :detalhes")})
public class Especificacoes implements Serializable {

    @OneToMany(mappedBy = "especificacao")
    private Collection<Produtos> produtosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "cor")
    private String cor;
    @Column(name = "sistema")
    private String sistema;
    @Column(name = "detalhes")
    private String detalhes;

    public Especificacoes() {
    }

    public Especificacoes(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especificacoes)) {
            return false;
        }
        Especificacoes other = (Especificacoes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.map.CadastroProdutos.dao.Especificacoes[ codigo=" + codigo + " ]";
    }

    @XmlTransient
    public Collection<Produtos> getProdutosCollection() {
        return produtosCollection;
    }

    public void setProdutosCollection(Collection<Produtos> produtosCollection) {
        this.produtosCollection = produtosCollection;
    }
    
}
