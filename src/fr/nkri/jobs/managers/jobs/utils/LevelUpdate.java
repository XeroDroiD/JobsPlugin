package fr.nkri.jobs.managers.jobs.utils;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.nkri.jobs.managers.jobs.PlayerJobManager;

public class LevelUpdate {

	private static HashMap<Integer, Integer> levelMap = new HashMap<Integer, Integer>();
	
	public static void update(Player player) {
		for(Entry<Integer, Integer> entry : levelMap.entrySet()) {
			if(PlayerJobManager.getLevel(player) < entry.getKey() && PlayerJobManager.getExp(player) >= entry.getValue()) {
				
				PlayerJobManager.addLevel(player, 1);
				PlayerJobManager.setExp(player, 0);
				player.sendMessage("§9§lJobs §r§7: §bVous venez de gagner §f1 niveau§b, vous avez §f" + PlayerJobManager.getLevel(player) + " niveaux§b !");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1L, 1L);
				
			}
		}
	}
	
	public static void setupLevel() {
		for(int i = 1; i != 100; i++) {
			levelMap.put(i, 10*i);
		}
	}
	
	public static int getExpNeedToLvl(int lvl) {
		if(lvl == 0) {
			return 0;
		}
		return levelMap.get(lvl);
	}
	
}
