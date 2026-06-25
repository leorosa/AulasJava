class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(); // instanciar objeto
        p.nome = "Ana";
        p.email = "ana@gmail.com";
//        System.out.println(p.nome + " " + p.email);
        p.display();
        
        Pessoa p2 = new Pessoa(); // instanciar objeto p2
        p2.nome = "João";
        p2.email = "joao@gmail.com";
//        System.out.println(p2.nome + " " + p2.email);
        p2.display();
    }
}

class Pessoa {
    String nome;
    String email;
    
    void display() {
        System.out.println(this.nome + " " + this.email);
    }
}