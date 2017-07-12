package modelo.dominio;

import java.sql.Date;

public class Exemplar {
	
	private int codExemp;
	private Date dtAquisicao;
	
	public Exemplar(int codExemp, Date dtAquisicao) {
		super();
		this.codExemp = codExemp;
		this.dtAquisicao = dtAquisicao;
	}

	public int getCodExemp() {
		return codExemp;
	}

	public void setCodExemp(int codExemp) {
		this.codExemp = codExemp;
	}

	public Date getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(Date dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	

}
