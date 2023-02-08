package fr.nkri.jobs.storage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDataBaseManager {
	
	public static SqlDataBase database;
	
	public static Connection getConnection() {
		
		if(database == null 
				|| !database.isConnected()) {
			
			database = null;
			database = new SqlDataBase("localhost", "youtube", "root", "");
			
			try {
				database.connection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return database.getConnection();
	}
	
	public static void createTable() {
		
		String request = "CREATE TABLE IF NOT EXISTS users (" 
		+ "uuid varchar(255) NOT NULL, "	
		+ "xp_hunter BIGINT, " 
		+ "lvl_hunter BIGINT, "
		+ "xp_miner BIGINT, " 
		+ "lvl_miner BIGINT, "
		+ "xp_farmer BIGINT, " 
		+ "lvl_farmer BIGINT)";
		
		try (Connection connetion = database.getConnection(); Statement statement = connetion.createStatement()){
			
			statement.execute(request);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
