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

//Java class to implement AWT Menu
//and MenuItem
import java.awt.*;
import java.awt.event.*;

public class exercicioObjetos {
    public static Scanner sc = new Scanner(System.in); // Create a Scanner object
    
    public static void main(String[] args) {
        
        Frame frame = new Frame("Menu Example");
        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        // Create a "File" menu
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

    	List<Produto> produtos = new ArrayList();
   
        novoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Produto p = new Produto();
                p.editar();
                produtos.add(p);
            }
        });

        alteraItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int i = selectItem(produtos);
            	produtos.get(i).editar();
            }
        });

        
        listaItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int i = selectItem(produtos);
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
        		int i = selectItem(produtos);
        		produtos.remove(i);
        	}
    	});

        sairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
      
/*
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
*/
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
