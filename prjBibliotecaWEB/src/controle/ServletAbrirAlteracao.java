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
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/abrirAlteracao")
public class ServletAbrirAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirAlteracao() {
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
		AutorDAO dao = new AutorDAO();
		Autor autor = dao.obter(codigo);
		
		request.setAttribute("autor", autor);
		
		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher("edicaoAutor.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
