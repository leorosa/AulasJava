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

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        List<Produto> produtos = new ArrayList();
        while (true) {
        	System.out.println("opções: [e]ntrar, [a]lterar, [l]istar produto, [L]istar todos, ou [r]emover");
    		String opcao = sc.nextLine();
    		if (opcao.equals("e")) {
    	        Produto p = new Produto();
                p.editar();
                produtos.add(p);
    		} else if (opcao.equals("a")) {
    			int i = 0;
    			for (Produto p : produtos) {
    				System.out.print(i + " ");
    				p.display();
    			}
    			i = sc.nextInt();
				Produto p = produtos.get(i);
				p.editar();
    		} else if (opcao.equals("r")) {
    			int i = 0;
    			for (Produto p : produtos) {
    				System.out.print(i + " ");
    				p.display();
    			}
    			i = sc.nextInt();
    			produtos.remove(i);
    		} else if (opcao.equals("l")) {
    			int i = 0;
    			for (Produto p : produtos) {
    				System.out.print(i + " ");
    				p.display();
    			}
    			i = sc.nextInt();
    			produtos.get(i).display();
    		} else if (opcao.equals("L")) {
    			for (Produto p : produtos) {
    				p.display();
    			}
    		}
        }
    }
}

class Produto {
    String descricao;
    double preco;
    int estoque;
    String unidade;

    void display() {
        System.out.println(this.descricao + "; preço: " + this.preco + "; estoque: " + this.estoque + "; unidade: " + this.unidade);
    }
    double desconto(double taxa) {
        return this.preco * (1-taxa/100);
    }
    double acrescimo(double taxa) {
        return this.preco * (1+taxa/100);
    }
    void editar() {
        Scanner sc = new Scanner(System.in); // Create a Scanner object
		System.out.print("nome: ");
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
