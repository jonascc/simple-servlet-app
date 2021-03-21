package servletapp.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletapp.model.User;
import servletapp.persistence.ConnectionPool;
import servletapp.persistence.dao.UsersDao;
import servletapp.persistence.util.DataBaseInitializer;

public class SignUp implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(name, lastName, email, password);

		try {
			try (Connection connection = new ConnectionPool().getConnection();
					Statement statement = connection.createStatement()) {

				DataBaseInitializer init = new DataBaseInitializer();
				statement.executeUpdate(init.sqlScriptToString("createdb.sql"));

				connection.setAutoCommit(false);
				UsersDao dao = new UsersDao(connection);

				dao.insert(user);
				connection.commit();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "forward:signUpSuccess.jsp";
	}

}
