package com.MCNation.command;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.MCNation.hub.ChatManager;
import com.MCNation.hub.Main;

public class TeleportManager {
	
	 @SuppressWarnings("unused")
	private Main plugin;
	 
	    public TeleportManager(Main instance) {
	        plugin = instance;
	    }
	
	@SuppressWarnings("deprecation")
	public static boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			Player p = (Player) sender;
		if(label.equalsIgnoreCase("tpall")){
			if(p.hasPermission("essentials.tpall")){
			if(args.length == 0){
				for(Player all : Bukkit.getServer().getOnlinePlayers()){
					all.teleport(p);
				}
					
			}else if(args.length == 1){
				if(Bukkit.getPlayer(args[0]) != null){
					for(Player all : Bukkit.getServer().getOnlinePlayers()){
						all.teleport(Bukkit.getPlayer(args[0]));
					}
				}else{
					p.sendMessage("that player doesnt exist");
			}
			}
		}
		else{
			p.sendMessage(ChatManager.permFormat);
		}}
		return false;
	}
}
