package modelo.dominio;

public class Leitor {

	private int codLeitor;
	private String nomeLeitor;
	private String endLeitor;
	private Integer telLeitor;
	
	public Leitor() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Leitor(int codLeitor, String nomeLeitor, String endLeitor, Integer telLeitor) {
		super();
		this.codLeitor = codLeitor;
		this.nomeLeitor = nomeLeitor;
		this.endLeitor = endLeitor;
		this.telLeitor = telLeitor;
	}
	
	
	public int getCodLeitor() {
		return codLeitor;
	}


	public void setCodLeitor(int codLeitor) {
		this.codLeitor = codLeitor;
	}


	public String getNomeLeitor() {
		return nomeLeitor;
	}


	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}


	public String getEndLeitor() {
		return endLeitor;
	}


	public void setEndLeitor(String endLeitor) {
		this.endLeitor = endLeitor;
	}


	public Integer getTelLeitor() {
		return telLeitor;
	}


	public void setTelLeitor(Integer telLeitor) {
		this.telLeitor = telLeitor;
	}


	
	
	
}
