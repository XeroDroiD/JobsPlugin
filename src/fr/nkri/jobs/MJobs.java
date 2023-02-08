package fr.nkri.jobs;

import org.bukkit.plugin.java.JavaPlugin;

import fr.nkri.jobs.storage.SqlDataBaseManager;

public class MJobs extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		setupDataBase();
		
	}
	
	private void setupDataBase() {
		SqlDataBaseManager.getConnection();
		SqlDataBaseManager.createTable();
	}
}
