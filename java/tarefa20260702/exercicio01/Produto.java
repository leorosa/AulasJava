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

    public void setDescricao(String descricao) {
        if (descricao.length()>0)
            this.descricao = descricao;
        else
            System.out.println("descrição inválida."); }
    public void setPreco(double preco) {
        if (preco>0)
            this.preco = preco;
        else
            System.out.println("preço inválido.");
    }
    public void setEstoque(int estoque) {
        if (estoque>=0)
            this.estoque = estoque;
        else
            System.out.println("estoque inválido.");
    }
    public void setUnidade(String unidade) {
        if (unidade.length()>0 && unidade.length()<=2)
            this.unidade = unidade;
        else
            System.out.println("unidade inválida.");
    }
}
