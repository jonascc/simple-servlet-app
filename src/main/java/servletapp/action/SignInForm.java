package servletapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInForm implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formSignIn.jsp";
	}

}
