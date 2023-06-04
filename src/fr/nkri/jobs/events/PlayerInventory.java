package fr.nkri.jobs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.utils.JobsUnit;

public class PlayerInventory implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		final Player player = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equals("§b§lMétiers")) {
			e.setCancelled(true);
			
			if(e.getCurrentItem() == null)return;
			
			switch (e.getCurrentItem().getType()) {
			case DIAMOND_SWORD:
				PlayerJobManager.setJobs(player, JobsUnit.HUNTER);
				player.sendMessage("§bVous venez d'activé le métier de Hunter");
				player.closeInventory();
				break;
			case DIAMOND_HOE:
				PlayerJobManager.setJobs(player, JobsUnit.FARMER);
				player.sendMessage("§bVous venez d'activé le métier de Farmeur");
				player.closeInventory();
				break;
			case DIAMOND_PICKAXE:
				PlayerJobManager.setJobs(player, JobsUnit.MINER);
				player.sendMessage("§bVous venez d'activé le métier de Mineur");
				player.closeInventory();
				break;
			default:
				break;
			}
		}
	}

}
