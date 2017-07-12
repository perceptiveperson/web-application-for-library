package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.LivroDAO;
import modelo.dominio.Livro;

/**
 * Servlet implementation class ServletExcluirProduto
 */
@WebServlet("/excluirLivro")
public class ServletExcluirLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirLivro() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigoStr = request.getParameter("codigo");
		Integer codigo = Integer.parseInt(codigoStr);
		
		// CARREGAR O PRODUTO DO BANCO
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.obter(codigo);
		
		if (livro == null)
		{
			request.setAttribute("mensagem", "O livro não existe no banco de dados!");
		}
		else
		{
			dao.remover(livro);
			request.setAttribute("mensagem", "O livro foi excluido com sucesso!");
		}
		
		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher("ListarLivros");
		disp.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
