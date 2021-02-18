package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.DBUtility;
import utility.UserDAOImpl;
import utility.UserLoginBusinessImpl;

public class LoginAction extends Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", request.getParameter("uname"));
		UserDAOImpl userDAO = new UserDAOImpl();
		UserLoginBusinessImpl ulb = new UserLoginBusinessImpl(userDAO);
		String username = request.getParameter("uname");
		String password  = request.getParameter("upass");
		if(ulb.checkUser(username, password)) {
			if(ulb.checkStatus(username)) {
				return "login.already";
			}
			ulb.updateStatus(username, 1);
			return "login.success";
		}
		return "login.register";
	}
	
}
