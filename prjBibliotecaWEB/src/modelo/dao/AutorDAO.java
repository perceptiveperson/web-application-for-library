package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Autor;

public class AutorDAO {
	
	private EntityManager manager = null;
	
	public AutorDAO() {
		super();
		this.manager = JPAUtil.getEntityManager();
		
	}
	
	public void incluir(Autor autor) {
		this.manager.getTransaction().begin();
		this.manager.persist(autor);
		this.manager.getTransaction().commit();
	}

	
	public void alterar(Autor autor) {
		this.manager.merge(autor);
		
	}

	public void remover(Autor autor) {
		this.manager.getTransaction().begin();
		this.manager.remove(autor);
		this.manager.getTransaction().commit();
		
	}

	public Autor obter(Integer codigo) {
		// CARREGAR O AUTOR PELA CHAVE PRIMÁRIA
		Autor retorno = this.manager.find(Autor.class, codigo);
		return retorno;
	}

	public List<Autor> obterTodos() {
		List<Autor> retorno = new ArrayList<Autor>();
		
		String jpql = "from Autor a order by a.nomeAutor asc";
		TypedQuery<Autor> query = this.manager.createQuery(jpql, Autor.class);

		retorno = query.getResultList();
		return retorno;
	}
}
