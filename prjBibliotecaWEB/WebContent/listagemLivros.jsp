<%@page import="modelo.dominio.Livro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros</title>
<link type="text/css" rel="stylesheet" href="./css/inicio.css" />
</head>
<body>
<div id="meio2">
<div id="meio3">
<%
	String mensagem = (String) request.getAttribute("mensagem");
	if (mensagem != null) 
	{
		out.print("<div style='color: blue'>" + mensagem + "</div>");
	}
%>
&nbsp
	<table>
		<tr>
			<td>Opções</td>
			<td>Código</td>
			<td>Titulo</td>
			<td>Ano</td>			
		</tr>
<%
 List<Livro> lista = (List<Livro>) request.getAttribute("listaLivros");

for (Livro livro : lista)
{
%>		
		<tr>
		<tr >
				<td class="linhaTab" colspan="4"></td>
			</tr>
		<td><a href="abrirAlteracao2?codigo=<%=livro.getCodLivro() %>">Alterar</a> - 
			<a href="excluirLivro?codigo=<%=livro.getCodLivro() %>">Excluir</a>
			</td>
			<td><%=livro.getCodLivro() %></td>
			<td><%=livro.getTituloLivro() %></td>
			<td><%=livro.getAnoLivro() %></td>
			<tr>
				<td  class="formatColor" colspan="4">Autor(s)</td>
			</tr>
			<tr>
				<td  class="format" colspan="4">
					<%=livro.getAutores() %> <input type="hidden" name="autores" value="<%=livro.getAutores() %>">
				
				</td>
			</tr>
			<tr >
				<td class="linhaTab" colspan="4"></td>
			</tr>
		</tr>
<%
}
%>	
	</table>
</div>	
<div id="esquerdo">
	<ul>
	<li>&nbsp</li>
	<li><a href="abrirInclusao2" target="iframe1">Incluir</a></li>
	
	</ul>
	</div>	
</div>	
</body>
</html>