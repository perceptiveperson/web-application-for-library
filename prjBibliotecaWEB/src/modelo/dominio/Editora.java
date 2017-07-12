package modelo.dominio;

public class Editora {
	
	private String nomeEditora;
	private String endEditora;
	private Integer telEditora;
	
	public Editora(String nomeEditora, String endEditora, Integer telEditora) {
		super();
		this.nomeEditora = nomeEditora;
		this.endEditora = endEditora;
		this.telEditora = telEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public String getEndEditora() {
		return endEditora;
	}

	public void setEndEditora(String endEditora) {
		this.endEditora = endEditora;
	}

	public Integer getTelEditora() {
		return telEditora;
	}

	public void setTelEditora(Integer telEditora) {
		this.telEditora = telEditora;
	}
	
	
	
}