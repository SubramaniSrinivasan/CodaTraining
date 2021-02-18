package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.UserDAOImpl;
import utility.UserLoginBusinessImpl;

public class LogoutAction extends Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("uname");
		
		UserDAOImpl userDAO = new UserDAOImpl();
		UserLoginBusinessImpl ulb = new UserLoginBusinessImpl(userDAO);
		
		ulb.updateStatus(username, 0);
		session.invalidate();
		return "logout.success";
	}
	
}
