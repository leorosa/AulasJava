/*
Criar classe produto com os atributos:
-descricao
-preco
-estoque
-unidade de medida

criar os métodos:
-> conceder desconto
-> conceder acréscimo

Crie um programa que permita ao usuário cadastrar produtos. 
O usuário deve informar os dados. Crie uma menu com opções de inserir novo produto, 
alterar um existente, excluir um existente, 
listar um produto de acordo com a descrição desejado e a opção para listar todos

Encapsular todos os atributos da classe Produto e validar para:
-> preço e estoque não sejam negativos;
-> a unidade de medida deve ter somente dois caracteres. 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class exercicioObjetos {
    public static Scanner sc = new Scanner(System.in);
    public static List<Produto> produtos = new ArrayList();

    public static void main(String[] args) {

        while (true) {
            if (produtos.size()==0)
                System.out.println("opções: [n]ovo produto ou [s]air");
            else
                System.out.println("opções: [n]ovo produto, [a]lterar produto, [l]istar produto, [L]istar todos, [r]emover ou [s]air");
            String opcao = sc.nextLine();
            if (opcao.equals("n")) {
                Produto p = new Produto();
                editar(p);
                produtos.add(p);
            } else if (opcao.equals("s")) {
                sc.close();
                break;
            } else if (produtos.size()==0) {
                continue;
            } else if (opcao.equals("a")) {
                int i = selectItem(produtos);
                editar(produtos.get(i));
            } else if (opcao.equals("r")) {
                int i = selectItem(produtos);
                produtos.remove(i);
            } else if (opcao.equals("l")) {
                int i = selectItem(produtos);
                produtos.get(i).display();
            } else if (opcao.equals("L")) {
                for (Produto p : produtos) {
                    p.display();
//                    System.out.println("=====");
                }
            }
        }
    }

    static int selectItem(List<Produto> produtos) {
        int i = 0;
        for (Produto p : produtos) {
            System.out.println(i + " " + p.getDescricao());
            i++;
        }
        i = -1;
        while (i<0||i>=produtos.size())
            i = sc.nextInt();
        sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
        return i;
    }

    static void editar(Produto produto) {
        System.out.print("descrição: ");
        produto.setDescricao(sc.nextLine());
        System.out.print("preço: ");
        produto.setPreco(sc.nextFloat());
        System.out.print("estoque: ");
        produto.setEstoque(sc.nextInt());
        System.out.print("unidade: ");
        sc.nextLine(); // consome o "\n" que sobrou do Enter anterior
        produto.setUnidade(sc.nextLine());
    }
}


/* ***** ***** ***** */

class Produto {
    private String descricao;
    private double preco;
    private int estoque;
    private String unidade;

    public void display() {
        System.out.println("--> " + this.descricao + "\npreço: " + this.preco + "\nestoque: " + this.estoque + "\nunidade: " + this.unidade);
    }
    double desconto(double taxa) {
        return this.preco * (1-taxa/100);
    }
    double acrescimo(double taxa) {
        return this.preco * (1+taxa/100);
    }

    public String getDescricao() { return this.descricao; }
    public double getPreco() { return this.preco; }
    public int getEstoque() { return this.estoque; }
    public String getUnidade() { return this.unidade; }

    public void setDescricao(String descricao) { if (descricao.length()>0) this.descricao = descricao; else System.out.println("descrição inválida."); }
    public void setPreco(double preco) { if (preco>0) this.preco = preco; else System.out.println("preço inválido."); }
    public void setEstoque(int estoque) { if (estoque>=0) this.estoque = estoque; else System.out.println("estoque inválido."); }
    public void setUnidade(String unidade) { if (unidade.length()>0 && unidade.length()<=2) this.unidade = unidade; else System.out.println("unidade inválida."); }
}
