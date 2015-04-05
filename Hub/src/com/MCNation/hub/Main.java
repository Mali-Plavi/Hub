package com.MCNation.hub;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

		public final Location[] warpLocations = new Location[100];
		public final String[] warpNames = new String[100];
		public int warpCounter = 0;
	    
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
			if(commandLabel.equalsIgnoreCase("setwarp")) {
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "/setwarp <warpname>");
				}else {
					Location location = player.getLocation();
					if(!(warpCounter > 100)) {
						warpLocations[warpCounter] = location;
						warpNames[warpCounter] = args[0];
						warpCounter++;
						player.sendMessage(ChatColor.GREEN + "Warp Set As: " + args[0]);
					}else {
						player.sendMessage(ChatColor.RED + "Warp Limit Exceeded! Unabled To Create Warp!");
						
					}
				}
			}else if(commandLabel.equalsIgnoreCase("warp")) {
				for(int i = 0; i < warpNames.length; i++) {
					String warpName = warpNames[i];
					if(args[0].equalsIgnoreCase(warpName)) {
						Location warpLocation = warpLocations[i];
						player.teleport(warpLocation);
						player.sendMessage(ChatColor.GREEN + "Teleported to " + warpName);
						break;
					}
				}
			}else if(commandLabel.equalsIgnoreCase("warps")) {
				String warps = "";
				for(int i = 0; i <warpNames.length; i++) {
					if(i !=warpNames.length) {
						warps+= warpNames[i] + ", ".replace("null", "");
					}else {
						player.sendMessage(ChatColor.DARK_GRAY + "Showing All Warps: " + ChatColor.GRAY + warps);
					}
				}
			}
			return false;
		}
}
