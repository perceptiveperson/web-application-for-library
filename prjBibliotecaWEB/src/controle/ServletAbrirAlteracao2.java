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
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/abrirAlteracao2")
public class ServletAbrirAlteracao2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirAlteracao2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// RECEBE O PARÂMETRO COMO STRING
		String codigoStr = request.getParameter("codigo");
		
		// CONVERTER PARA INTEGER
		Integer codigo = Integer.parseInt(codigoStr);
		
		// LER O PRODUTO REFERENTE AO CÓDIGO PASSADO
		LivroDAO dao = new LivroDAO();
		Livro livro = dao.obter(codigo);
		
		request.setAttribute("livro", livro);
		
		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher("edicaoLivro.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
