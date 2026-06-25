class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto();
        arroz.descricao = "arroz";
        arroz.preco = 3.99;
        arroz.estoque = 100;
        arroz.unidade = "kg";
        arroz.printDesconto();
        arroz.printAcrescimo();
    }
}

class Produto {
    String descricao;
    double preco;
    int estoque;
    String unidade;
    
    void printDesconto() {
        System.out.println(this.descricao + " custa R$" + this.preco*0.9 + " com 10% de desconto.");
    }
    void printAcrescimo() {
        System.out.println(this.descricao + " custa R$" + this.preco*1.1 + " com 10% de taxa.");
    }

}