package fr.nkri.jobs;

import org.bukkit.plugin.java.JavaPlugin;

import fr.nkri.jobs.events.PlayerJoin;
import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.managers.users.UserManager;
import fr.nkri.jobs.storage.SqlDataBaseManager;

public class MJobs extends JavaPlugin{
	
	public static String prefix = "§b§lJobs §r§8»§r ";
	private UserManager userManager;
	private PlayerJobManager playerJobManager;
	
	@Override
	public void onEnable() {
		
		setupDataBase();
		
		playerJobManager = new PlayerJobManager();
		userManager = new UserManager();
		
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
	}
	
	private void setupDataBase() {
		SqlDataBaseManager.getConnection();
		SqlDataBaseManager.createTable();
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public PlayerJobManager getPlayerJobManager() {
		return playerJobManager;
	}
	
	public static String getPrefix() {
		return prefix;
	}
}
