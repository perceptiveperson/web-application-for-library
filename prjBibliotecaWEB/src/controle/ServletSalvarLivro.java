package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.AutorDAO;
import modelo.dao.LivroDAO;
import modelo.dominio.Autor;
import modelo.dominio.Livro;

/**
 * Servlet implementation class ServletSalvarProduto
 */
@WebServlet("/salvarLivro")
public class ServletSalvarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private List<Autor> autores;
//	private Integer[] codigoAutor;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarLivro() {
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
		String titulo = request.getParameter("titulo");
		String ano = request.getParameter("ano");
		
		
		//String[] codigoStrAutor = request.getParameterValues("codigoAutor");
				
		Integer codigo;
		
	
		try {
			codigo = Integer.parseInt(codigoStr);
		} catch (NumberFormatException e1) {
			codigo = null;
		}
		
		/*try {
			for(int i=0; i<=codigoStrAutor.length; i++){
				
				codigoAutor[i] = Integer.parseInt(codigoStrAutor[i]);
			}
			
		} catch (NumberFormatException e1) {
			for(int i=0; i<=codigoStrAutor.length; i++){
				
			codigoAutor[i] = null;
			}
		}*/

		// CONVERTER PARA NÚMEROS
		Integer anoLivro;
		

		List<String> erros = new ArrayList<String>();

		if ((titulo == null) || (titulo.isEmpty()))
			erros.add("O campo título não pode estar vazio.");

		if ((ano == null) || (ano.isEmpty()))
			erros.add("O campo ano não pode estar vazio.");
		
		//if ((codigoStrAutor.length == 0) || (codigoStrAutor.equals(null)))
		//	erros.add("Deve ter pelo menos um autor selecionado.");
		
		try {
			anoLivro = Integer.parseInt(ano);

			if (anoLivro <= 0)
				erros.add("O ano deve ser um número maior que zero.");
		} catch (Exception e) {
			anoLivro = null;
			erros.add("O ano é inválido.");
		}


		// CRIAR UM OBJETO LIVRO PARA ARMAZENAR OS DADOS
		LivroDAO dao = new LivroDAO();
		Livro livro;
		
		AutorDAO dao2 = new AutorDAO();
		
		
/*		for( int i=0; i>codigoAutor.length; i++){
			
here			autores.add(dao2.obter(codigoAutor[i]));
		}
		
*/		
		if (codigo == null)
			livro = new Livro();
		else
			livro = dao.obter(codigo);
			
		livro.setCodLivro(codigo);
		livro.setTituloLivro(titulo);
		livro.setAnoLivro(anoLivro);
		
//		livro.setAutores(autores);

		String pagina;

		if (erros.isEmpty()) {
			// INCLUIR OS DADOS NO BANCO
			dao.incluir(livro);

			pagina = "ListarLivros";
		} else {
			pagina = "edicaoLivro.jsp";
		}

		request.setAttribute("livro", livro);
		request.setAttribute("erros", erros);

		// ENVIAR O PROCESSAMENTO PARA A PÁGINA JSP
		RequestDispatcher disp = request.getRequestDispatcher(pagina);
		disp.forward(request, response);

	}

}
