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
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class exercicioObjetos {
    public static Scanner sc = new Scanner(System.in);
    public static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            if (produtos.size()==0)
                System.out.println("opções: [n]ovo produto ou [s]air");
            else
                System.out.println("opções: [n]ovo produto, [a]lterar produto, [l]istar produto, [L]istar todos, [r]emover ou [s]air");
            String opcao = sc.nextLine();
            if (opcao.equals("n")) {
                Produto p = new Produto();
                p.editar();
                produtos.add(p);
            } else if (opcao.equals("s")) {
                break;
            } else if (produtos.size()==0) {
                continue;
            } else if (opcao.equals("a")) {
                int i = selectItem(produtos);
                produtos.get(i).editar();
            } else if (opcao.equals("r")) {
                int i = selectItem(produtos);
                produtos.remove(i);
            } else if (opcao.equals("l")) {
                int i = selectItem(produtos);
                produtos.get(i).display();
            } else if (opcao.equals("L")) {
                for (Produto p : produtos) {
                    p.display();
                }
            }
        }
    }

    static int selectItem(List<Produto> produtos) {
        int i = 0;
        for (Produto p : produtos) {
            System.out.println(i + " " + p.descricao);
            i++;
        }
        i = -1;
        while (i<0||i>=produtos.size())
            i = sc.nextInt();
        sc.nextLine(); // Consome o "\n" que sobrou do Enter anterior
        return i;
    }
}

class Produto {
    String descricao;
    double preco;
    int estoque;
    String unidade;

    void display() {
        System.out.println(this.descricao + "\npreço: " + this.preco + "\nestoque: " + this.estoque + "\nunidade: " + this.unidade);
    }
    double desconto(double taxa) {
        return this.preco * (1-taxa/100);
    }
    double acrescimo(double taxa) {
        return this.preco * (1+taxa/100);
    }
    void editar() {
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        System.out.print("descrição: ");
        this.descricao = sc.nextLine();
        System.out.print("preço: ");
        this.preco = sc.nextFloat();
        System.out.print("estoque: ");
        this.estoque = sc.nextInt();
        System.out.print("unidade: ");
        sc.nextLine(); // Consome o "\n" que sobrou do Enter anterior
        this.unidade = sc.nextLine();
    }
}
