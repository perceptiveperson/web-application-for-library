package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_autores")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// @Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "ID_AUTOR", sequenceName = "SEQ_ID_AUTOR", allocationSize = 1, initialValue = 1)
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_AUTOR")
	private Integer codAutor;
	
	@Column(name = "nomeautor", length = 120, nullable = false, unique = true)
	private String nomeAutor = "";
	
	@Column(name = "nacioautor", length = 120, nullable = false, unique = false)
	private String nacioAutor = "";
	
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;
	
	public Autor() {
		super();
	}
	
	public Autor(Integer codAutor, String nomeAutor, String nacioAutor) {
		super();
		this.codAutor = codAutor;
		this.nomeAutor = nomeAutor;
		this.nacioAutor = nacioAutor;
				
	}

	public Integer getCodAutor() {
		return codAutor;
	}
	
	public String getCodigoFormatado() {
		
		if (this.codAutor == null)
			return "";
		
		return codAutor.toString();
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getNacioAutor() {
		return nacioAutor;
	}

	public void setNacioAutor(String nacioAutor) {
		this.nacioAutor = nacioAutor;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public String toString(){
		return this.getNomeAutor();
	}
	
}
