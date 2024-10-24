package br.edu.ifsp.arq.ads.ifitness.servlets.helpers;

import com.google.gson.JsonObject;

import br.edu.ifsp.arq.ads.ifitness.model.daos.ActivityDao;
import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.utils.SearcherDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteActivityHelper implements Helper {

	@Override
	public JsonObject execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Long activityId = Long.parseLong(req.getParameter("activity-id"));
		Boolean response;	
		ActivityDao activityDao = new ActivityDao(SearcherDataSource.getInstance().getDataSource());
		Activity activity = activityDao.getActivitiesById(activityId); 
		if(activity != null) {
			activityDao.delete(activity);
			response = true;
		}else {
			response = false;
		}
		JsonObject json = new JsonObject();
		json.addProperty("response", response);
		return json;
	}

}