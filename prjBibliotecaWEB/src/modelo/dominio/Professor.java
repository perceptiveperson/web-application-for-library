package modelo.dominio;

public class Professor extends Leitor{
	
	private String discProfessor;

	public Professor(int codLeitor, String nomeLeitor, String endLeitor, Integer telLeitor, 
			String discProfessor) {
		super(codLeitor, nomeLeitor, endLeitor, telLeitor);
		this.discProfessor = discProfessor;
	}

	
	public String getDiscProfessor() {
		return discProfessor;
	}

	public void setDiscProfessor(String discProfessor) {
		this.discProfessor = discProfessor;
	}
	
	

}
