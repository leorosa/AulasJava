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

//Java class to implement AWT Menu and MenuItem
import java.awt.*;
import java.awt.event.*;

public class exercicioObjetos {
    public static Scanner sc = new Scanner(System.in);
    public static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {

        Frame frame = new Frame("Menu Example");
        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        Menu prodMenu = new Menu("produto");
        MenuItem novoItem = new MenuItem("novo");
        MenuItem alteraItem = new MenuItem("alterar");
        MenuItem listaItem = new MenuItem("listar");
        MenuItem listaTodos = new MenuItem("listar todos");
        MenuItem removeItem = new MenuItem("remover");
        MenuItem sairItem = new MenuItem("sair");
        prodMenu.add(novoItem);
        prodMenu.add(alteraItem);
        prodMenu.add(listaItem);
        prodMenu.add(listaTodos);
        prodMenu.add(removeItem);
        prodMenu.addSeparator();
        prodMenu.add(sairItem);
        menuBar.add(prodMenu);
        frame.setSize(300, 100);
        frame.setVisible(true);

        novoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Produto p = new Produto();
                p.editar();
                produtos.add(p);
            }
        });

        alteraItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (produtos.size()==0) return;
                int i = selectItem();
                produtos.get(i).editar();
            }
        });

        listaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (produtos.size()==0) return;
                int i = selectItem();
                produtos.get(i).display();
            }
        });

        listaTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Produto p : produtos) {
                    p.display();
                }
            }
        });

        removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (produtos.size()==0) return;
                int i = selectItem();
                produtos.remove(i);
            }
        });

        sairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    static int selectItem() {
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
