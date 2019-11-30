/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.CadastroProdutos.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Washington
 */
public class MensagensUtil {
    
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");
    public static final Locale ES_ES = new Locale("es", "ES");
    
    private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", PT_BR);
    
    public static final String MSG_VALIDACAO_NOME = "msg.validacao.nome";
    public static final String MSG_VALIDACAO_PRECO = "msg.validacao.preco";
    public static final String MSG_ERRO_SELECIONAR = "msg.erro.selecionar";
    public static final String MSG_ERRO_CONSULTAR = "msg.erro.consultar ";
    public static final String LABEL_NOME  = "label.nome";
    public static final String LABEL_PRECO  = "label.preco";
    public static final String LABEL_COR  = "label.cor";
    public static final String LABEL_FABRICANTE  = "label.fabricante";
    public static final String LABEL_SISTEMA  = "label.sistema";
    public static final String LABEL_DETALHES  = "label.detalhes";
    public static final String TITULO_FRAME_PRODUTO  = "titulo.frame.produto";
    public static final String LABEL_BUSCAR  = "label.buscar";
    public static final String LABEL_TITULO  = "label.titulo";
    public static final String LABEL_NOVO_TITULO  = "label.novo.titulo";
    public static final String LABEL_EDITAR_TITULO  = "label.editar.titulo";
    public static final String BUTTON_SALVAR = "button.salvar";
    public static final String BUTTON_CANCELAR = "button.cancelar";
    public static final String BUTTON_NOVO = "button.novo";
    public static final String BUTTON_EDITAR = "button.editar";
    public static final String BUTTON_EXCLUIR = "button.excluir";
    public static final String BUTTON_SAIR = "button.sair";
    public static final String TABELA_CODIGO = "tabela.codigo";
    public static final String TABELA_NOME = "tabela.nome";
    public static final String TABELA_PRECO = "tabela.preco";
    public static final String MENU_IDIOMA = "menu.idioma";
    public static final String MENU_IDIOMA_PT_BR = "menu.idioma.pt.br";
    public static final String MENU_IDIOMA_EN_US = "menu.idioma.en.us";
    public static final String MENU_IDIOMA_ES_ES = "menu.idioma.es.es";
    public static final String MENU_RELATORIO = "menu.relatorio";
    public static final String MENU_RELATORIO_LISTA_PRODUTO = "menu.relatorio.lista.produto";
    public static final String MENU_RELATORIO_LISTA_PRODUTO_PRECO_MAIOR = "menu.relatorio.lista.produto.preco.maior";
    public static final String MENU_RELATORIO_LISTA_PRODUTO_PRECO_MENOR = "menu.relatorio.lista.produto.preco.menor";
    public static final String MSG_RELATORIO_PRECO_REFERENCIA_MAIOR = "msg.relatorio.preco.referencia.maior";
    public static final String MSG_RELATORIO_PRECO_REFERENCIA_MENOR = "msg.relatorio.preco.referencia.menor";
    
    
    public static String getMensagem(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale local){
        resource = ResourceBundle.getBundle("mensagens", local);
    }
}
