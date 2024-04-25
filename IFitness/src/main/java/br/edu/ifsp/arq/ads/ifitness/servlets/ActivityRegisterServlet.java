package br.edu.ifsp.arq.ads.ifitness.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.daos.UserDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.model.entities.ActivityType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;

@WebServlet("/activityRegister")
public class ActivityRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ActivityRegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		ActivityType type = ActivityType.valueOf(req.getParameter("type"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		Double distance = Double.parseDouble(req.getParameter("distance"));
		Integer duration = Integer.parseInt(req.getParameter("duration"));

		// buscar User logado
		Optional<User> optional = getLoggedUser(req);

		RequestDispatcher dispatcher = null;
		
		if(optional.isPresent()) {
			ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
			Activity activity = new Activity();
			activity.setType(type);
			activity.setDate(date);
			activity.setDistance(distance);
			activity.setDuration(duration);
			activity.setUser(optional.get());
			if(id == 0) {
				if(activityDao.save(activity)) {
					req.setAttribute("result", "registered");
					dispatcher = req.getRequestDispatcher("/activity-register.jsp");
				}
			}else {
				activity.setId(id);
				if(activityDao.update(activity)) {
					req.setAttribute("result", "registered");
					dispatcher = req.getRequestDispatcher("/activity-register.jsp");
				}
			}	
		} else {
			req.setAttribute("result", "notRegistered");
			dispatcher = req.getRequestDispatcher("/activity-register.jsp");
		}

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Long activityId = Long.parseLong(req.getParameter("activity-id"));
		
		ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
		Activity activity = activityDao.getActivitiesById(activityId);
		RequestDispatcher dispatcher = null;
		if(activity != null) {
			if(action.equals("update")) {
				req.setAttribute("activity", activity);
				dispatcher = req.getRequestDispatcher("/activity-register.jsp");
			}
			if(action.equals("delete")) {
				activityDao.delete(activity);
				dispatcher = req.getRequestDispatcher("/homeServlet");
			}
		}else {
			dispatcher = req.getRequestDispatcher("/homeServlet");
		}
		dispatcher.forward(req, resp);
	}

	private Optional<User> getLoggedUser(HttpServletRequest req) {
		Optional<User> optional = Optional.empty();
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loggedUser")) {
					UserDao userDao = new UserDao(SearcherDataSource.getInstance().getDataSource());
					optional = userDao.getUserByEmail(c.getValue());
				}
			}
		}
		return optional;
	}

}