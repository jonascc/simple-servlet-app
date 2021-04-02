package servletapp.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import servletapp.model.User;

public class UsersDao {
	
	
private final Connection con;
	
	public UsersDao(Connection con) {
		this.con = con;
	}
	
	public void insert(User user) throws SQLException {
		String sql = "Insert into users "
				+ "(name, lastName, email, password)"
				+ "values(?, ?, ?, ?)";
		
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			
			stmt.execute();
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					user.setId(id);
				}
			}
		}
	}
	
	public User retrieveUser(User user) throws SQLException {
		String sql = "select * from users where email = ? and password = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				if (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String lastName = rs.getString("lastName");
					String email = rs.getString("name");
					return new User.Builder().id(id).name(name).lastName(lastName).email(email).build();
				} else {
					return null;
				}
			}
		}
		
	}
	
	public void deleteUser(User user) throws SQLException {
		String sql = "delete from users where id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, user.getId());
			
			stmt.execute();
		}
		
	}
	
	public void updateUser(User user) throws SQLException {
		String sql = "update users set name = ?, lastName = ? where id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getLastName());
			stmt.setInt(3, user.getId());
			
			stmt.execute();
		}
		
	}
	

}
