package modelo.dominio;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_livros")
// @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// @Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Livro {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_LIVRO")
	@SequenceGenerator(name = "ID_LIVRO", sequenceName = "SEQ_ID_LIVRO", allocationSize = 1)
	private Integer codLivro;
	
	@Column(name = "tituloLivro", length = 120, nullable = false, unique = true)
	private String tituloLivro = "";
	
	@Column(name = "anoLivro", length = 120, nullable = false, unique = true)
	private Integer anoLivro = 0;
	 
	@ManyToMany
	@JoinTable(name = "Livro_Autor",
				joinColumns = @JoinColumn(name = "livro_id", nullable = false),
				inverseJoinColumns = @JoinColumn(name = "autor_id", nullable = false))
	private List<Autor> autores;
	
	public Livro(){
		super();
	}
	
	public Livro(Integer codigo, String tituloLivro, Integer anoLivro) {
		super();
		this.codLivro = codigo;
		this.tituloLivro = tituloLivro;
		this.anoLivro = anoLivro;
	}

	public Integer getCodLivro() {
		return codLivro;
	}
	
	public String getCodigoFormatado() {
		
		if (this.codLivro == null)
			return "";
		
		return codLivro.toString();
	}
	

	public void setCodLivro(Integer codLivro) {
		this.codLivro = codLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public Integer getAnoLivro() {
		return anoLivro;
	}

	public void setAnoLivro(Integer anoLivro) {
		this.anoLivro = anoLivro;
	}
	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
