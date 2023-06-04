package fr.nkri.jobs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.utils.JobsUnit;

public class PlayerProgresse implements Listener{
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity().getKiller() instanceof Player) {
			final Player player = e.getEntity().getKiller();
		
			if(PlayerJobManager.getJobs(player).getJobsUnit() == JobsUnit.HUNTER) {
				switch (e.getEntity().getType()) {
				case ZOMBIE:
					addXp(player, 10);
					break;
				case SKELETON:
					addXp(player, 20);
					break;
				case CREEPER:
					addXp(player, 30);
					break;
				default:
					break;
				}
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		final Player player = e.getPlayer();
		
		if(PlayerJobManager.getJobs(player).getJobsUnit() == JobsUnit.MINER) {
			switch (e.getBlock().getType()) {
			case DIAMOND_ORE:
				addXp(player, 10);
				break;
			case COAL_ORE:
				addXp(player, 20);
				break;
			case IRON_ORE:
				addXp(player, 30);
				break;
			default:
				break;
			}
		}
		
		if(PlayerJobManager.getJobs(player).getJobsUnit() == JobsUnit.FARMER) {
			switch (e.getBlock().getType()) {
			case MELON_BLOCK:
				addXp(player, 10);
				break;
			case CARROT:
				if(e.getBlock().getData() == 7) {
					addXp(player, 20);
				}
				break;
			case SUGAR_CANE_BLOCK:
				addXp(player, 30);
				break;
			default:
				break;
			}
		}
		
	}
	
	
	private void addXp(Player player, int xp) {
		PlayerJobManager.getJobs(player).addXp(xp);
		player.sendMessage("§9§lJobs §r§7(§cHunter§7): §bVous venez de reçevoir §l"+ xp + "expériences§r§b !");
	}

}
