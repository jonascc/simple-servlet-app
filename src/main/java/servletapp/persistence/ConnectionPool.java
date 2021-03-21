package servletapp.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

public class ConnectionPool {
	
	private DataSource dataSource;
	
	public ConnectionPool() {
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:hsqldb:file:C:/HSQL_databases/simple-servlet-app/database01;shutdown=true;hsqldb.write_delay=false");
		pool.setUser("SA");
		pool.setPassword("");
		this.dataSource = pool;
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}

}
