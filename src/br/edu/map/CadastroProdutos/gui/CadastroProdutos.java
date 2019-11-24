package br.edu.map.CadastroProdutos.gui;

/**
 *
 * @author Washington
 */

import br.edu.map.CadastroProdutos.dao.ProdutoDAO;
import br.edu.map.CadastroProdutos.model.Especificacao;
import br.edu.map.CadastroProdutos.model.Produto;

import java.util.List;
import java.util.Scanner;

public class CadastroProdutos {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String op;
        ProdutoDAO dao = new ProdutoDAO();
        Produto p;
        Especificacao e;

        do {
            System.out.println("-----------< MENU >-----------");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - EDITAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - CONSULTAR");
            System.out.println("0 - SAIR");
            System.out.print(": ");

            op = input.nextLine();

            System.out.println("Opção selecionada: " + op);

            switch (op) {
                case "1":
                    System.out.println("\n---------< CADASTRAR >--------");
                    p = new Produto();
                    p.setEspecificacao(new Especificacao());
                    System.out.print("Nome: ");
                    p.setNome(input.nextLine());
                    System.out.print("Preço: ");
                    p.setPreco(Float.parseFloat(input.nextLine()));
                    System.out.print("Fabricante: ");
                    p.getEspecificacao().setFabricante(input.nextLine());
                    System.out.print("Cor: ");
                    p.getEspecificacao().setCor(input.nextLine());
                    System.out.print("Sistema: ");
                    p.getEspecificacao().setSistema(input.nextLine());
                    System.out.print("Detalhes: ");
                    p.getEspecificacao().setDetalhes(input.nextLine());
                    dao.inserir(p);
                    System.out.println("Produto cadastrado com sucesso!\n");
                    break;
                case "2":
                    {
                        System.out.println("\n----------< EDITAR >----------");
                        System.out.print("Informe o código do produto: ");
                        int codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null) {
                            System.out.println("\n-------< DADOS ATUAIS >-------");
                            System.out.println(p);
                            
                            System.out.println("\n--------< NOVOS DADOS >-------");
                            System.out.print("Nome: ");
                            String entrada = input.nextLine();
                            p.setNome((entrada.equals("")) ? p.getNome() : entrada);
                            
                            System.out.print("Preço: ");
                            entrada = input.nextLine();
                            p.setPreco((entrada.equals("") ? p.getPreco() : Float.parseFloat(entrada)));
                            
                            System.out.print("Fabricante: ");
                            entrada = input.nextLine();
                            p.getEspecificacao().setFabricante((entrada.equals("") ? p.getEspecificacao().getFabricante() : entrada));
                            
                            System.out.print("Cor: ");
                            entrada = input.nextLine();
                            p.getEspecificacao().setCor(entrada.equals("") ? p.getEspecificacao().getCor() : entrada);
                            
                            System.out.print("Sistema: ");
                            entrada = input.nextLine();
                            p.getEspecificacao().setSistema(entrada.equals("") ? p.getEspecificacao().getSistema() : entrada);
                            
                            System.out.print("Detalhes: ");
                            entrada = input.nextLine();
                            p.getEspecificacao().setDetalhes(entrada.equals("") ? p.getEspecificacao().getDetalhes() : entrada);
                            
                            dao.editar(p);
                            
                            System.out.println("Produto editado com sucesso!\n");
                        }
                        else {
                            System.out.println("Produto não encontrado!\n");
                        }       break;
                    }
                case "3":
                    {
                        System.out.println("\n---------< EXCLUIR >----------");
                        System.out.print("Informe o código do produto: ");
                        int codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null) {
                            dao.remover(p);
                            System.out.println("Produto excluido com sucesso!\n");
                        }
                        else {
                            System.out.println("Produto não encontrado!\n");
                        }       break;
                    }
                case "4":
                    System.out.println("\n---------< CONSULTAR >--------");
                    List<Produto> produtos = dao.listar();
                    produtos.forEach((produto) -> {
                        System.out.println(produto);
                    }); System.out.println("");
                    break;
                default:
                    break;
            }
        } while (!op.equals("0"));
    }
}