<%@page import="modelo.dominio.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autores</title>
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
			<td>Nacionalidade</td>
			<td>Nome</td>			
		</tr>
<%
 List<Autor> lista = (List<Autor>) request.getAttribute("listaAutores");

for (Autor autor : lista)
{
%>
		<tr>
		<td><a href="abrirAlteracao?codigo=<%=autor.getCodAutor() %>">Alterar</a> - 
				<a href="excluirAutor?codigo=<%=autor.getCodAutor() %>">Excluir</a>
			</td>
			<td><%=autor.getCodAutor() %></td>
			<td><%=autor.getNacioAutor() %></td>
			<td><%=autor.getNomeAutor() %></td>			
		</tr>
<%
}
%>	
	</table>
</div>	
<div id="esquerdo">
	<ul>
	<li>&nbsp</li>
	<li><a href="abrirInclusao" target="iframe1">Incluir</a></li>
	
	</ul>
	</div>	
</div>	
</body>
</html>