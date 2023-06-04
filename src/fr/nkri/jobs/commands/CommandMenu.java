package fr.nkri.jobs.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.nkri.jobs.utils.ItemsBuilder;

public class CommandMenu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		
		if(label.equalsIgnoreCase("job")) {
			
			Inventory inventory = Bukkit.createInventory(null, 9*3, "§b§lMétiers");
			
			for(int i =0; i != 9*3;i++) {
				inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1));
			}
			
			inventory.setItem(11, ItemsBuilder.createItemWithNameAndLore(Material.DIAMOND_SWORD, 1, "§cHunter", new String[] {"§7Tuer le plus de mob", "§eblabla", "§eblable"}));
			inventory.setItem(12, ItemsBuilder.createItemWithNameAndLore(Material.DIAMOND_HOE, 1, "§aFarmeur", new String[] {"§7Casser le plus de carrot", "§eblabla", "§eblable"}));
			inventory.setItem(14, ItemsBuilder.createItemWithNameAndLore(Material.DIAMOND_PICKAXE, 1, "§eMineur", new String[] {"§7Casser du diamant!", "§eblabla", "§eblable"}));

			player.openInventory(inventory);
		}
		
		return false;
	}

}
