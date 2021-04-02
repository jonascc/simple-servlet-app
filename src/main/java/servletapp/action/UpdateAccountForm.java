package servletapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAccountForm implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formUpdateAccount.jsp";
	}

}
