package com.MCNation.hub;

import org.bukkit.ChatColor;
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
			return false;
		}
}
