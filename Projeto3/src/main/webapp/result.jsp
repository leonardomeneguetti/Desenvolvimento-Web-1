<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,br.edu.ifsp.arq.ads.dw1s5.projeto4.model.Person"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Lista de pessoas cadastradas</title>
</head>
<body>
	<%
		List<Person> personsList = (List<Person>)request.getAttribute("personsList");
	%>
	<table>
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>E-mail</th>
		</tr>
		<%
			for(Person person : personsList) {
				
			
		%>
			<tr>
				<td><%= person.getName() %></td>
				<td><%= person.getCpf() %></td>
				<td><%= person.getEmail() %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>