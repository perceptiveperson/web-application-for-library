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

import modelo.dao.LivroDAO;
import modelo.dominio.Livro;

/**
 * Servlet implementation class ServletListarAutores
 */
@WebServlet(name = "ListarLivros", urlPatterns = { "/ListarLivros" })
public class ServletListarLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarLivros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	           // LER OS DADOS DOS Livros DO BANCO						
				LivroDAO dao = new LivroDAO();
				List<Livro> lista = dao.obterTodos();
				
				// GUARDAR A LISTA NO REQUEST
				request.setAttribute("listaLivros", lista);
				
				// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
				RequestDispatcher disp = request.getRequestDispatcher("listagemLivros.jsp");
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
