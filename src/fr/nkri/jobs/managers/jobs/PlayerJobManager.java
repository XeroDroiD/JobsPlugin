package fr.nkri.jobs.managers.jobs;

import java.util.HashMap;

import org.bukkit.entity.Player;

import fr.nkri.jobs.utils.JobsUnit;

public class PlayerJobManager {

	private static HashMap<Player, PlayerJob> playerMap;
	
	public PlayerJobManager() {
		playerMap = new HashMap<>();
	}

	public static void init(Player player) {
		
		if(!playerMap.containsKey(player)) {
			playerMap.put(player, new PlayerJob(player));
		}
	}
	
	public static void setJobs(Player player, JobsUnit jobsUnit) {
		
		if(jobsUnit != getJobs(player).getJobsUnit()) {
			
			/*
			 * Sauvegarde bdd
			 */
			
			playerMap.get(player).setLvl(0);
			playerMap.get(player).setXp(0);
			playerMap.get(player).setJobsUnit(jobsUnit);
		}
	}
	
	public static PlayerJob getJobs(Player player) {
		return playerMap.get(player);
	}
	
	public static void addExp(Player player, int exp) {
		playerMap.get(player).addXp(exp);
	}
	
	public static int getExp(Player player) {
		return playerMap.get(player).getXp();
	}
	
	public static void addLevel(Player player, int lvl) {
		playerMap.get(player).addLvl(lvl);
	}
	
	public static int getLevel(Player player) {
		return playerMap.get(player).getLvl();
	}
	
	public static HashMap<Player, PlayerJob> getPlayerMap() {
		return playerMap;
	}
}
