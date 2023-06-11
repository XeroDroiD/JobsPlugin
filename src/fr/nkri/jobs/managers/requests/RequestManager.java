package fr.nkri.jobs.managers.requests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import org.bukkit.entity.Player;

import fr.nkri.jobs.managers.jobs.PlayerJob;
import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.storage.SqlDataBaseManager;
import fr.nkri.jobs.utils.JobsUnit;

public class RequestManager {

    public static int getLevel(Player player, String lvl) {
		
		try {
			
			PreparedStatement preparedStatement = SqlDataBaseManager.getConnection().prepareStatement("SELECT " + lvl + " FROM users WHERE uuid= ?");
			preparedStatement.setString(1, player.getUniqueId().toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			int level = 0;
			while(rs.next()) {
				level = rs.getInt(lvl);
			}
			preparedStatement.close();
			
			return level;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void setLevel(Player player, int lvl, String lvlRequest) {
		
		try {
			PreparedStatement preparedStatement = SqlDataBaseManager.getConnection().prepareStatement("UPDATE users SET " +lvlRequest+ "= ? WHERE uuid= ?");
			preparedStatement.setInt(1, lvl);
			preparedStatement.setString(2, player.getUniqueId().toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addLevel(Player player, int lvl, String lvlRequest) {
		setLevel(player, getLevel(player, lvlRequest) + lvl, lvlRequest);
	}
	
   public static int getExp(Player player, String exp) {
		
		try {
			
			PreparedStatement preparedStatement = SqlDataBaseManager.getConnection().prepareStatement("SELECT " + exp + " FROM users WHERE uuid= ?");
			preparedStatement.setString(1, player.getUniqueId().toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			int level = 0;
			while(rs.next()) {
				level = rs.getInt(exp);
			}
			preparedStatement.close();
			
			return level;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void setExp(Player player, int exp, String expRequest) {
		
		try {
			PreparedStatement preparedStatement = SqlDataBaseManager.getConnection()
					.prepareStatement("UPDATE users SET " +expRequest+ "= ? WHERE uuid= ?");
			preparedStatement.setInt(1, exp);
			preparedStatement.setString(2, player.getUniqueId().toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addExp(Player player, int exp, String expRequest) {
		setLevel(player, getExp(player, expRequest) + exp, expRequest);
	}
	
	public static void sendData() {
		
		for(Entry<Player, PlayerJob> entry : PlayerJobManager.getPlayerMap().entrySet()) {
			JobsUnit jobsUnit = entry.getValue().getJobsUnit();
			
			setLevel(entry.getKey(), entry.getValue().getLvl(), jobsUnit.getLvl());
			setExp(entry.getKey(), entry.getValue().getXp(), jobsUnit.getExp());
		}
	}
}

