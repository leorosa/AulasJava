
public class Aula03 {

	public static void main(String[] args) {
//		operadoresMatematicos();
//		operadoresComparacao();
		desviosSimples();
	}

	static void desviosSimples() {
		int x = 10;
		int y = 20;
		if(x < y) {
			System.out.println(x + " é menor que " + y);
		}
		System.out.println("fim do programa");
	}

	static void operadoresComparacao() {
		int x = 10;
		int y = 30;
		System.out.println(x<y);
		System.out.println(x>y);
		System.out.println(x==y);
		System.out.println(x!=y);
		System.out.println(x<=y);
		System.out.println(x>=y);
	}

	static void operadoresMatematicos() {
		int x = 10;
		int y = 3;
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++y);
	}
	
}
