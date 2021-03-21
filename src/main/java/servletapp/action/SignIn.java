package servletapp.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servletapp.model.User;
import servletapp.persistence.ConnectionPool;
import servletapp.persistence.dao.UsersDao;
import servletapp.persistence.util.DataBaseInitializer;

public class SignIn implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User.Builder().email(email).password(password).build();
		
		try {
			try (Connection connection = new ConnectionPool().getConnection();
					Statement statement = connection.createStatement()) {

				DataBaseInitializer init = new DataBaseInitializer();
				statement.executeUpdate(init.sqlScriptToString("createdb.sql"));

				connection.setAutoCommit(false);
				UsersDao dao = new UsersDao(connection);

				User userSignedIn = dao.retrieveUser(user);
				//connection.commit();
				
				if(userSignedIn != null) {
					HttpSession session = request.getSession();
					session.setAttribute("signedInUser", userSignedIn);
					return "redirect:app?action=UserPage";
				} else {
					return "redirect:app?action=SignInForm";
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
