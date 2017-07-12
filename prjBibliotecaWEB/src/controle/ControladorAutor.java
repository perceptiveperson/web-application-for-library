package controle;

import java.util.List;
import modelo.dao.AutorDAO;
import modelo.dominio.Autor;

public class ControladorAutor {
	
	public List listarAutores(){
	
		AutorDAO dao = new AutorDAO();
		List<Autor> lista = dao.obterTodos();
				
		return lista;
	}
}
