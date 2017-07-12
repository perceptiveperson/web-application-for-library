package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private JPAUtil()
	{
		super();
	}

	private static EntityManagerFactory factory = null;
	
	public static EntityManager getEntityManager()
	{
		if (JPAUtil.factory == null)
		{
			JPAUtil.factory = Persistence.createEntityManagerFactory("banco2");;
		}
		
		return JPAUtil.factory.createEntityManager();
	}
	
	
}
