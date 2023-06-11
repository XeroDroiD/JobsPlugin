package fr.nkri.jobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.nkri.jobs.commands.CommandJobs;
import fr.nkri.jobs.commands.CommandMenu;
import fr.nkri.jobs.events.PlayerInventory;
import fr.nkri.jobs.events.PlayerJoinQuit;
import fr.nkri.jobs.events.PlayerProgresse;
import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.managers.jobs.utils.LevelUpdate;
import fr.nkri.jobs.managers.requests.RequestManager;
import fr.nkri.jobs.managers.users.UserManager;
import fr.nkri.jobs.storage.SqlDataBaseManager;

public class MJobs extends JavaPlugin{
	
	public static String prefix = "§b§lJobs §r§8»§r ";
	private UserManager userManager;
	private PlayerJobManager playerJobManager;
	
	@Override
	public void onEnable() {
		
		kickPlayers();
		setupDataBase();
		
		playerJobManager = new PlayerJobManager();
		userManager = new UserManager();
		
		LevelUpdate.setupLevel();
		
		getServer().getPluginManager().registerEvents(new PlayerJoinQuit(this), this);
		getServer().getPluginManager().registerEvents(new PlayerInventory(), this);
		getServer().getPluginManager().registerEvents(new PlayerProgresse(), this);
		getCommand("jobs").setExecutor(new CommandJobs());
		getCommand("job").setExecutor(new CommandMenu());

		Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
			
			@Override
			public void run() {
				RequestManager.sendData();
			}
		}, 0L, 20*30);
		
	}
	
	private void setupDataBase() {
		SqlDataBaseManager.getConnection();
		SqlDataBaseManager.createTable();
	}
	
	private void kickPlayers() {
		for(Player pls : Bukkit.getOnlinePlayers()) {
			pls.kickPlayer("§cRestoration de la base de donnée.");
		}
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
