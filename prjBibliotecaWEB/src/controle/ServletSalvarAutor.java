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
 * Servlet implementation class ServletSalvarProduto
 */
@WebServlet("/salvarAutor")
public class ServletSalvarAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarAutor() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// this.doPost(request, response);

		response.sendError(403, "ESTE MÉTODO NÃO PERMITE ACESSO VIA URL.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// LER OS DADOS DIGITADOS NO FORMULÁRIO
		String codigoStr = request.getParameter("codigo");
		String nacionalidade = request.getParameter("nacionalidade");
		String nome = request.getParameter("nome");
		
		Integer codigo;
		try {
			codigo = Integer.parseInt(codigoStr);
		} catch (NumberFormatException e1) {
			codigo = null;
		}

			

		List<String> erros = new ArrayList<String>();

		if ((nacionalidade == null) || (nacionalidade.isEmpty()))
			erros.add("O campo nacionalidade não pode estar vazio.");

		if ((nome == null) || (nome.isEmpty()))
			erros.add("O campo nome não pode estar vazio.");

		// CRIAR UM OBJETO PRODUTO PARA ARMAZENAR OS DADOS
		AutorDAO dao = new AutorDAO();
		Autor autor;
		if (codigo == null)
			autor = new Autor();
		else
			autor = dao.obter(codigo);
		
		autor.setCodAutor(codigo);
		autor.setNacioAutor(nacionalidade);
		autor.setNomeAutor(nome);

		String pagina;

		if (erros.isEmpty()) {
			// INCLUIR OS DADOS NO BANCO
			dao.incluir(autor);

			pagina = "ListarAutores";
		} else {
			pagina = "edicaoAutor.jsp";
		}

		request.setAttribute("autor", autor);
		request.setAttribute("erros", erros);

		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher(pagina);
		disp.forward(request, response);

	}

}
