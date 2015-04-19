package com.MCNation.hub;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.MCNation.chat.Nicknames;
import com.MCNation.command.TeleportManager;
import com.MCNation.economy.Economy;


public class Main extends JavaPlugin{
		
		public final Location[] warpLocations = new Location[100];
		public final String[] warpNames = new String[100];
		public int warpCounter = 0;
	    
		private FileConfiguration warpc = null;
		private File warpf = null;
		@SuppressWarnings("unused")
		private Main instance;
		
		
		
		
		
		public void reloadWarpConfig() {
		    if (warpf == null) {
		    warpf = new File(getDataFolder(), "warp.yml");
		    }
		    warpc = YamlConfiguration.loadConfiguration(warpf);
		}
		
		
		public FileConfiguration getWarpConfig() {
		    if (warpc == null) {
		        reloadWarpConfig();
		    }
		    return warpc;
		}
		
		public void saveWarpConfig() {
		    if (warpc == null || warpf == null) {
		        return;
		    }
		    try {
		        getWarpConfig().save(warpf);
		    } catch (IOException ex) {
		        getLogger().log(Level.SEVERE, "Could not save config to " + warpf, ex);
		    }
		}
		
		@SuppressWarnings("unused")
		private static final Logger log = Logger.getLogger("Minecraft");
		
	    @Override
		public void onEnable() {
			this.getServer().getPluginManager().registerEvents(new Listener(), this);
			this.getConfig().options().copyDefaults(true);
			getCommand("command_name").setExecutor(new Enforcement(this));
		}
		
		@Override
		public void onDisable() {
			saveWarpConfig();
		}
		//Help
		@SuppressWarnings({ "unused", "deprecation" })
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
			} //Warps
			if(commandLabel.equalsIgnoreCase("setwarp")) {
				if(player.hasPermission("setwarp")||player.isOp()){
				FileConfiguration c = getWarpConfig();
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "/setwarp <warpname>");
				}else {
					Location location = player.getLocation();
					if(!(warpCounter > 100)) {
						c.set(args[0], location);
						saveWarpConfig();
						warpCounter++;
						player.sendMessage(ChatColor.GREEN + "Warp Set As: " + args[0]);
						}else {
						player.sendMessage(ChatColor.RED + "Warp Limit Exceeded! Unabled To Create Warp!");
						
						}
					}
				}
			}else if(commandLabel.equalsIgnoreCase("warp")) {
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "/warp <warpname>");
				}else{
					if(getWarpConfig().contains(args[0])){
						if(player.hasPermission("warp." + args[0])){
							player.teleport((Location) getWarpConfig().get(args[0]));
							player.sendMessage(ChatColor.GREEN + "Sucuessfuly warped to " + args[0]);
						}
				}else{
					player.sendMessage(ChatColor.RED + "That warp doesen't exist");
				}
				}
			}else if(commandLabel.equalsIgnoreCase("warps")) {
				String warps = "";
				player.sendMessage("TO BE IMPLEMENTED");
					
				}
			Enforcement.Command(sender, cmd, commandLabel, args);
			TeleportManager.onCommand(sender, cmd, commandLabel, args);
			
			Economy e = new Economy(this);
			
			e.Command(sender, cmd, commandLabel, args);
			Nicknames.onCommand(sender, cmd, commandLabel, args);
			return false;
		} //Join Message
		
}
