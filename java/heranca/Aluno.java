
public class Aluno extends Pessoa {
	private double media;
	
	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}
	
	public String getStatus() {
		return media<7 ? "Reprovado" : "Aprovado";
	}
	
	public void display() {
/*		System.out.println("Nome: " + getNome());
		System.out.println("Email: " + getEmail()); */
		super.display();
		System.out.println("Media: " + media);
		System.out.println("Status: " + getStatus());
	}
}
