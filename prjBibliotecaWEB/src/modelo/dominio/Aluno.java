package modelo.dominio;

public class Aluno extends Leitor{
	
	private String cursoAluno;
	private String turmaAluno;
	
	
	public Aluno(int codLeitor, String nomeLeitor, String endLeitor, Integer telLeitor) {
		super(codLeitor, nomeLeitor, endLeitor, telLeitor);
		// TODO Auto-generated constructor stub
	}
	public Aluno(String cursoAluno, String turmaAluno) {
		super();
		this.cursoAluno = cursoAluno;
		this.turmaAluno = turmaAluno;
	}
	public String getCursoAluno() {
		return cursoAluno;
	}
	public void setCursoAluno(String cursoAluno) {
		this.cursoAluno = cursoAluno;
	}
	public String getTurmaAluno() {
		return turmaAluno;
	}
	public void setTurmaAluno(String turmaAluno) {
		this.turmaAluno = turmaAluno;
	}
	
	

}
