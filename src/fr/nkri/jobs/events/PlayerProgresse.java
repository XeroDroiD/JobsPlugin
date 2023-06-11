package fr.nkri.jobs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.managers.jobs.utils.LevelUpdate;
import fr.nkri.jobs.utils.JobsUnit;

public class PlayerProgresse implements Listener{
	
	@EventHandler
	public void onKill(EntityDeathEvent e) {
		
		if(e.getEntity().getKiller() instanceof Player) {
			final Player player = e.getEntity().getKiller();
		
			if(PlayerJobManager.getJobs(player).getJobsUnit() == JobsUnit.HUNTER) {
				switch (e.getEntity().getType()) {
				case ZOMBIE:
					addXpHunter(player, 1);
					break;
				case SKELETON:
					addXpHunter(player, 2);
					break;
				case CREEPER:
					addXpHunter(player, 3);
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
				addXpMiner(player, 1);
				break;
			case COAL_ORE:
				addXpMiner(player, 2);
				break;
			case IRON_ORE:
				addXpMiner(player, 3);
				break;
			default:
				break;
			}
		}
		
		if(PlayerJobManager.getJobs(player).getJobsUnit() == JobsUnit.FARMER) {
			switch (e.getBlock().getType()) {
			case MELON_BLOCK:
				addXpFarmer(player, 1);
				break;
			case CARROT:
				if(e.getBlock().getData() == 7) {
					addXpFarmer(player, 2);
				}
				break;
			case SUGAR_CANE_BLOCK:
				addXpFarmer(player, 3);
				break;
			default:
				break;
			}
		}
		
	}
	
	
	private void addXpHunter(Player player, int xp) {
		PlayerJobManager.getJobs(player).addXp(xp);
		player.sendMessage("§9§lJobs §r§7(§cHunter§7): §bVous venez de reçevoir §l"+ xp + "expériences§r§b !");
		LevelUpdate.update(player);
	}
	
	@SuppressWarnings("unused")
	private void addXpFarmer(Player player, int xp) {
		PlayerJobManager.getJobs(player).addXp(xp);
		player.sendMessage("§9§lJobs §r§7(§aFarmeur§7): §bVous venez de reçevoir §l"+ xp + "expériences§r§b !");
		LevelUpdate.update(player);
	}
	
	private void addXpMiner(Player player, int xp) {
		PlayerJobManager.getJobs(player).addXp(xp);
		player.sendMessage("§9§lJobs §r§7(§eMineur§7): §bVous venez de reçevoir §l"+ xp + "expériences§r§b !");
		LevelUpdate.update(player);
	}

}
