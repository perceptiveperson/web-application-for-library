package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AutorDAO;
import modelo.dominio.Autor;

/**
 * Servlet implementation class ServletExcluirProduto
 */
@WebServlet("/excluirAutor")
public class ServletExcluirAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirAutor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigoStr = request.getParameter("codigo");
		Integer codigo = Integer.parseInt(codigoStr);
		
		// CARREGAR O PRODUTO DO BANCO
		AutorDAO dao = new AutorDAO();
		Autor autor = dao.obter(codigo);
		
		if (autor == null)
		{
			request.setAttribute("mensagem", "O autor não existe no banco de dados!");
		}
		else
		{
			dao.remover(autor);
			request.setAttribute("mensagem", "O autor foi excluido com sucesso!");
		}
		
		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher("ListarAutores");
		disp.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
