class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto();
        arroz.descricao = "arroz";
        arroz.preco = 3.99;
        arroz.estoque = 100;
        arroz.unidade = "kg";
        arroz.printDesconto(10);
        arroz.printAcrescimo(5);
        arroz.display();
    }
}

// normalmente a classe está em arquivo separado
class Produto {
    String descricao;
    double preco;
    int estoque;
    String unidade;
    
    void printDesconto(double taxa) {
        System.out.println(this.descricao + " custa R$" + this.preco*(1-taxa/100) + " com " + taxa + "% de desconto.");
    }
    void printAcrescimo(double taxa) {
        System.out.println(this.descricao + " custa R$" + this.preco*(1+taxa/100) + " com " + taxa +"% de taxa.");
    }

    void display() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Preço:     " + this.preco);
        System.out.println("Estoque:   " + this.estoque);
        System.out.println("Unidade:   " + this.unidade);
    }
}