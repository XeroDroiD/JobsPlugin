package fr.nkri.jobs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.nkri.jobs.managers.jobs.PlayerJobManager;
import fr.nkri.jobs.utils.JobsUnit;

public class CommandJobs implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("jobs")) {
			
			if(args.length == 0) {
				sendHelp(player);
				return false;
			}
 
			switch (args[0].toLowerCase()) {
			case "hunter":
				PlayerJobManager.setJobs(player, JobsUnit.HUNTER);
				player.sendMessage("§4Votre niveau: §c" + PlayerJobManager.getLevel(player));
				break;
			case "mineur":
				PlayerJobManager.setJobs(player, JobsUnit.MINER);
				player.sendMessage("§4Votre niveau: §c" + PlayerJobManager.getLevel(player));
				break;
			case "farmeur":
				PlayerJobManager.setJobs(player, JobsUnit.FARMER);
				player.sendMessage("§4Votre niveau: §c" + PlayerJobManager.getLevel(player));
				break;
			default:
				sendHelp(player);
				break;
			}
		}
		
		return false;
	}

	private void sendHelp(Player player) {
		player.sendMessage("§8§m--------------[§bJobs§8§m]--------------");
		player.sendMessage("§9/jobs hunter");
		player.sendMessage("§factive le job de chasseur");
		player.sendMessage("§9/jobs mineur");
		player.sendMessage("§factive le job de mineur");
		player.sendMessage("§9/jobs farmeur");
		player.sendMessage("§factive le job de farmeur");
		player.sendMessage("§8§m--------------[§bJobs§8§m]--------------");
	}

}
