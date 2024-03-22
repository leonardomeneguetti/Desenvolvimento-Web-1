package br.edu.ifsp.arq.dw1s5.exercicio2;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RegisterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//obter os dados da requisição
		String data = req.getParameter("date");
		int dia = Integer.parseInt(data.substring(0, 1));
		int mes = Integer.parseInt(data.substring(3, 4));
		int ano = Integer.parseInt(data.substring(6));
		int idade;
		if(mes < 3) {
			idade = 2024 - ano - 1;
		} else {
			idade = 2024 - ano;
		}
		
		//escrever a resposta
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>");
		writer.println("<html lang=\"pt-BR\">");
		writer.println("<head>");
		writer.println("\t<meta charset=\"UTF-8\">");
		writer.println("\t<title>Página de Resposta - Exercicio 2</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("\t<h1>Cadastro realizado com sucesso!</h1>");
		writer.println("\t<h2>Idade: " + idade + "</h2>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
