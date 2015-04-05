package com.MCNation.hub;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

		@Override
		public void onEnable() {
			this.getServer().getPluginManager().registerEvents(new Listener(), this);
			this.getConfig().options().copyDefaults(true);
		}
		
		@Override
		public void onDisable() {
			
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			Player player = (Player) sender;
			if(commandLabel.equalsIgnoreCase("help")) {
				player.sendMessage(ChatColor.GOLD + "A more comprehensive help system will come in the future.");
			}
			if(commandLabel.equalsIgnoreCase("teleport")) {
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "Too little arguments.");
				}else if(args.length == 1) {
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					Location targetPlayerLocation = targetPlayer.getLocation();
					player.teleport(targetPlayerLocation);
				}else if(args.length == 2) {
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					Player targetPlayer1 = player.getServer().getPlayer(args[1]);
				    Location targetPlayer1Location = targetPlayer1.getLocation();
				    targetPlayer.teleport(targetPlayer1Location);
				}
			}
			return false;
		}
}
