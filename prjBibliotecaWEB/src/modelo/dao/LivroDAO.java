package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.dominio.Autor;
import modelo.dominio.Livro;

public class LivroDAO {
	
	private EntityManager manager = null;
		
	public LivroDAO() {
		super();

		this.manager = JPAUtil.getEntityManager();
		
	}

	
	public void incluir(Livro livro) {
		// ABRIR TRANSAÇÃO
		this.manager.getTransaction().begin();
		// INCLUIR PRODUTO
		this.manager.persist(livro);
		// FECHAR TRANSAÇÃO
		this.manager.getTransaction().commit();
	}

	public void alterar(Livro livro) {
		
		this.manager.merge(livro);
		
	}

	public void remover(Livro livro) {
		// ABRIR TRANSAÇÃO
		this.manager.getTransaction().begin();
		// INCLUIR PRODUTO
		this.manager.remove(livro);
		// FECHAR TRANSAÇÃO
		this.manager.getTransaction().commit();
	}

	public Livro obter(Integer codigo) {
		// CARREGAR O PRODUTO PELA CHAVE PRIMÁRIA
		Livro retorno = this.manager.find(Livro.class, codigo);
		return retorno;
	}

	public List<Livro> obterTodos() {
		List<Livro> retorno = new ArrayList<Livro>();
		
		String jpql = "from Livro l order by l.tituloLivro asc";
		TypedQuery<Livro> query = this.manager.createQuery(jpql, Livro.class);

		retorno = query.getResultList();
		return retorno;
	}
	

}
