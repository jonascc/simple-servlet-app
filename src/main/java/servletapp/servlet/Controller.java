package servletapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletapp.action.Action;

@WebServlet(urlPatterns = "/app")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Servlet called.");
		

		String actionParam = request.getParameter("action") != null ? request.getParameter("action") : "";
		
		String className = "servletapp.action." + actionParam;
		System.out.println("className: " + className);

		String actionsReturn;
		try {
			Class actionClass = Class.forName(className);
			Action action = (Action) actionClass.newInstance();
			actionsReturn = action.execute(request, response);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			throw new ServletException(e);
		}

		String[] actionsReturnArr = actionsReturn.split(":");
		if (actionsReturnArr[0].equals("forward")) {
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("WEB-INF/view/" + actionsReturnArr[1]);
			reqDispatcher.forward(request, response);
		} else if (actionsReturnArr[0].equals("redirect")) {
			response.sendRedirect(actionsReturnArr[1]);
		} else {
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("WEB-INF/view/home.jsp");
			reqDispatcher.forward(request, response);
		}

	}

}
