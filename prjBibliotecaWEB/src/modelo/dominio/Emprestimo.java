package modelo.dominio;

import java.util.Date;

public class Emprestimo {
	
	private Date dtEmpre;
	private Date dtPreDevol;
	private Date dtDevol;
	
	public Emprestimo(Date dtEmpre, Date dtPreDevol, Date dtDevol) {
		super();
		this.dtEmpre = dtEmpre;
		this.dtPreDevol = dtPreDevol;
		this.dtDevol = dtDevol;
	}

	public Date getDtEmpre() {
		return dtEmpre;
	}

	public void setDtEmpre(Date dtEmpre) {
		this.dtEmpre = dtEmpre;
	}

	public Date getDtPreDevol() {
		return dtPreDevol;
	}

	public void setDtPreDevol(Date dtPreDevol) {
		this.dtPreDevol = dtPreDevol;
	}

	public Date getDtDevol() {
		return dtDevol;
	}

	public void setDtDevol(Date dtDevol) {
		this.dtDevol = dtDevol;
	}
	
	

}
