package io.github.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GrantCommand implements CommandExecutor   {
	 private ItemLibrary items = new ItemLibrary();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("grant")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Console cannot run this command!");
				return true;
			}
			Player player = (Player) sender;
			if(args.length == 0) {
				player.sendMessage(ChatColor.RED + "Please type in an item name!");
				return true;
			}
			if(player.isOp()) {
				if(args[0].equalsIgnoreCase("pistol")) {
					player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.pistolItem().getItemMeta().getDisplayName().toString() + "");
					player.getInventory().addItem(items.pistolItem());
				}
				if(player.isOp()) {
					if(args[0].equalsIgnoreCase("autoRifle")) {
						player.sendMessage(ChatColor.GRAY + "You have obtained... " + ChatColor.GREEN + items.autoRifleItem().getItemMeta().getDisplayName().toString() + "");
						player.getInventory().addItem(items.autoRifleItem());
					}
				}
				
				
				
			}
			
			}
		return true;

}

}
