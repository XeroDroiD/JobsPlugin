package fr.nkri.jobs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.nkri.jobs.MJobs;
import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.managers.requests.RequestManager;
import fr.nkri.jobs.utils.JobsUnit;

public class PlayerJoinQuit implements Listener {

	private MJobs main;
	public PlayerJoinQuit(MJobs main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		final Player player = e.getPlayer();
		
		main.getUserManager().load(player);
		
		PlayerJobManager.setJobs(player, JobsUnit.HUNTER);
		PlayerJobManager.addExp(player, 30);
		PlayerJobManager.addLevel(player, 20);

		player.sendMessage("§7Vous êtes: " + PlayerJobManager.getJobs(player).getJobsUnit().getDisplay());
		player.sendMessage("§7Level: §e" + PlayerJobManager.getJobs(player).getLvl());
		player.sendMessage("§7Exp: §e" + PlayerJobManager.getJobs(player).getXp());		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		RequestManager.sendData();
	}
}
