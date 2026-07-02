public class Main {

	public static void main(String[] args) {
		Produto p = new Produto(1,"milho",1.75);

//		p.setId(1);
//		p.setDescricao("milho");
//		p.setPreco(1.75);
//		p.setEstoque(10);

		System.out.println(p);
		System.out.println(p.getId());
		System.out.println(p.getDescricao());
		System.out.println(p.getPreco());
		System.out.println(p.getEstoque());
	}

}
