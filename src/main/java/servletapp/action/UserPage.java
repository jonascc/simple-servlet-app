package servletapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserPage implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:userPage.jsp";
	}

}