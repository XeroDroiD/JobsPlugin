package fr.nkri.jobs.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataBase {

	private Connection connection;
	private String host, database, user, password;
	
	public SqlDataBase(String host, String database, String user, String password) {
		this.host = host;
		this.database = database;
		this.user = user;
		this.password = password;
	}
	
	public void connection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?autoReconnect=true&allowMultiQueries=true", user, password);
	}
	
	public boolean isConnected() {
		try {
			return !getConnection().isClosed();
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
