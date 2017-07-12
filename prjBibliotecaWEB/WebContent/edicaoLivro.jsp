<%@page import="modelo.dominio.Livro"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dominio.Autor"%>
<%@page import="controle.ControladorAutor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Livro</title>

<link type="text/css" rel="stylesheet" href="./css/inicio.css" />
<script language="JavaScript" src="./js/inicio.js"></script>

</head>
<body>
<div id="meio2">
<div id="meio3">
<jsp:useBean id="livro" scope="request" class="modelo.dominio.Livro"></jsp:useBean>
<jsp:useBean id="CtrlAutor" scope="request" class="controle.ControladorAutor"></jsp:useBean>
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
	<p><b>Digite os dados do Livro:</b></p>
	
	<form action="salvarLivro" method="post">
	<table>
		<tr>
			<td>Codigo:</td>
			<td><%=livro.getCodigoFormatado() %> <input type="hidden" name="codigo" value="<%=livro.getCodLivro() %>"></td>
		</tr>
		<tr>
			<td>Título:</td>
			<td><input type="text" name="titulo" value="<%=livro.getTituloLivro() %>" size="50" maxlength="100"></td>
		</tr>
		<tr>
			<td>Ano:</td>
			<td><input type="text" name="ano" value="<%=livro.getAnoLivro() %>" size="50" maxlength="100"></td>
		</tr>
		
		<tr>
			<td colspan="2" class="formatColor"><b>Autor(s) Selecionado(s)</b></td>
		</tr>
		<tr>
			<td colspan="2" class="format">
				<%=livro.getAutores() %> <input type="hidden" name="autores" value="<%=livro.getAutores() %>">
				
				
			</td> 
		</tr>
		<tr>
			<td colspan="2" class="format"><input type="submit" value="Gravar livro">
			    <a href="ListarLivros"><input type="button" value="Cancelar"></a>
		</tr>
	</table>
	</form>
</div>	
<div id="esquerdo">
	<ul>
	<li><li>&nbsp</li>
	<li><a href="abrirInclusao2" target="iframe1">Incluir</a></li>
	
	</ul>
			
</div>	
</div>

</body>
</html>

	
