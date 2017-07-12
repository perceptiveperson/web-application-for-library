<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Autor</title>
<link type="text/css" rel="stylesheet" href="./css/inicio.css" />
</head>
<body>
<div id="meio2">
<div id="meio3">
<jsp:useBean id="autor" scope="request" class="modelo.dominio.Autor"></jsp:useBean>
<%
//     FAZ TYPE CAST ou CASTING PARA O TIPO ARMAZENADO NO REQUEST
List<String> erros = (List<String>) request.getAttribute("erros");
if ((erros != null) && (!erros.isEmpty()))
{
	out.print("<ul style='color: red'>");
	for (String erro : erros)
		out.print("<li>" + erro + "</li>");
	
	out.print("</ul>");
}
%>
	<p><b>Digite os dados do Autor:</b></p>
	
	<form action="salvarAutor" method="post">
	<table>
		<tr>
			<td>Codigo:</td>
			<td><%=autor.getCodigoFormatado() %> <input type="hidden" name="codigo" value="<%=autor.getCodAutor() %>"></td>
		</tr>
		<tr>
			<td>Nacionalidade:</td>
			<td><input type="text" name="nacionalidade" value="<%=autor.getNacioAutor() %>" size="50" maxlength="100"></td>
		</tr>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" value="<%=autor.getNomeAutor() %>" size="50" maxlength="100"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Gravar autor"></td>
		</tr>
	</table>
	</form>
</div>	
<div id="esquerdo">
	<ul>
	<li><li>&nbsp</li>
	<li><a href="abrirInclusao" target="iframe1">Incluir</a></li>
	
	</ul>
			
</div>	
</div>
</body>
</html>