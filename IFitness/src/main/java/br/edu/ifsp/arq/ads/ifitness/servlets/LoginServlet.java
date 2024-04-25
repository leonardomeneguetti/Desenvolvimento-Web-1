package br.edu.ifsp.arq.ads.ifitness.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.ads.ifitness.model.daos.UserDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDao userDao = 
				new UserDao(
						SearcherDataSource.getInstance()
						.getDataSource());
		Optional<User> optional = 
				userDao.getUserByEmailAndPassword(email, password);
		RequestDispatcher dispatcher = null;
		if(optional.isPresent()) {
			// gravar o cookie
			Cookie cookie = new Cookie("loggedUser", email);
			cookie.setMaxAge(60*60*24);
			resp.addCookie(cookie);
			// redirecionar para página de boas-vindas
			req.setAttribute("name", optional.get().getName());
			dispatcher = req.getRequestDispatcher("/homeServlet");
		}else {
			// remover o cookie
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				for(Cookie c: cookies) {
					if(c.getName().equals("loggedUser")) {
						c.setMaxAge(0);
						resp.addCookie(c);
					}
				}
			}
			// permanecer na página de login
			req.setAttribute("result", "loginError");
			dispatcher = req.getRequestDispatcher("/login.jsp");
		}
		dispatcher.forward(req, resp);
	}
	
	

}