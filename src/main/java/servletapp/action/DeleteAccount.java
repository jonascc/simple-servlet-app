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

public class DeleteAccount implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("signedInUser");
		
		if(user != null) {
			try (Connection connection = new ConnectionPool().getConnection();
					Statement statement = connection.createStatement()) {
				
				connection.setAutoCommit(false);
				UsersDao dao = new UsersDao(connection);
				
				dao.deleteUser(user);
				connection.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
		}

		return "redirect:app?action=SignOut";
	}

}
