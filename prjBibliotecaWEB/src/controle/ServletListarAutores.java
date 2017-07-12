package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AutorDAO;
import modelo.dominio.Autor;

/**
 * Servlet implementation class ServletListarAutores
 */
@WebServlet(name = "ListarAutores", urlPatterns = { "/ListarAutores" })
public class ServletListarAutores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarAutores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	           // LER OS DADOS DOS AUTORES DO BANCO						
				AutorDAO dao = new AutorDAO();
				List<Autor> lista = dao.obterTodos();
				
				// GUARDAR A LISTA NO REQUEST
				request.setAttribute("listaAutores", lista);
				
				// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
				RequestDispatcher disp = request.getRequestDispatcher("listagemAutores.jsp");
				disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
