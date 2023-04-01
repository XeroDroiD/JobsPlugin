package fr.nkri.jobs.managers.users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import fr.nkri.jobs.MJobs;
import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.storage.SqlDataBaseManager;

public class UserManager {

	public List<Player> userData;
	
	public UserManager() {
		userData = new ArrayList<>();
	}
	
	public void load(Player player) {
		
		userData.add(player);
		
		PlayerJobManager.init(player);
		
		try {
			PreparedStatement preparedStatement = SqlDataBaseManager.getConnection().prepareStatement("SELECT * FROM users WHERE uuid=?");
			preparedStatement.setString(1, player.getUniqueId().toString());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				
				PreparedStatement request = SqlDataBaseManager.getConnection()
						.prepareStatement("INSERT INTO users (uuid, xp_hunter, lvl_hunter, xp_miner, lvl_miner, xp_farmer, lvl_farmer) VALUES (?, ?, ?, ?, ?, ?, ?)");
				
				request.setString(1, player.getUniqueId().toString());
				request.setInt(2, 0);
				request.setInt(3, 0);
				request.setInt(4, 0);
				request.setInt(5, 0);
				request.setInt(6, 0);
				request.setInt(7, 0);
				
				request.execute();
				request.close();
				
				player.sendMessage(MJobs.getPrefix() + " §fCréation de votre profil avec succès !");
			}
			else {
				player.sendMessage(MJobs.getPrefix() + " §fRécupération de vos données avec succès !");
			}
		} 
		catch (SQLException e) {
			player.sendMessage(MJobs.getPrefix() + " §cUne erreur est survenue lors de la récupération des données.");
			e.printStackTrace();
		}
		
	}
	
}
