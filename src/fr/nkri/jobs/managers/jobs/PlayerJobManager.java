package fr.nkri.jobs.managers.jobs;

import java.util.HashMap;

import org.bukkit.entity.Player;

import fr.nkri.jobs.managers.requests.RequestManager;
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
			
			if(playerMap.get(player).getLvl() != 0 && playerMap.get(player).getXp() != 0) {
				RequestManager.sendData();
			}

			playerMap.get(player).setJobsUnit(jobsUnit);
			playerMap.get(player).setLvl(RequestManager.getLevel(player, jobsUnit.getLvl()));
			playerMap.get(player).setXp(RequestManager.getLevel(player, jobsUnit.getExp()));
			
		}
		else {
			player.sendMessage("§cVous avez déjà activé ce jobs.");
		}
	}
	
	public static PlayerJob getJobs(Player player) {
		return playerMap.get(player);
	}
	
	public static void addExp(Player player, int exp) {
		playerMap.get(player).addXp(exp);
	}
	
	public static void setExp(Player player, int exp) {
		playerMap.get(player).setXp(exp);
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
