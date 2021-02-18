package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.UserDAOImpl;
import utility.UserLoginBusinessImpl;

public class RegisterAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String option = request.getParameter("option");
		if(option.equals("yes")) {
			UserDAOImpl userDAO = new UserDAOImpl();
			UserLoginBusinessImpl ulb = new UserLoginBusinessImpl(userDAO);
			ulb.registerUser(request.getParameter("uname"), request.getParameter("upass"));
			return "register.success";
		}
		return "register.failure";
	}
}
