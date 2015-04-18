package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.MCNation.economy.Economy;

public class EconomyCmd {
	
	private static Economy e = new Economy();
	
		public static boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
			if(sender instanceof Player){
			Player p = (Player) sender;
				if(p.hasPermission("economy.change")){
					if(l.equalsIgnoreCase("setbalance")){
						if(args.length == 1){
							e.setBalance(p, Integer.parseInt(args[0]));
						}else if(args.length == 2){
							if(Bukkit.getPlayer(args[1]) != null){
								e.setBalance(Bukkit.getPlayer(args[1]), Integer.parseInt(args[0]));
							}else{
								p.sendMessage(ChatColor.RED + "That player does not exist");
							}
						}else{
							p.sendMessage(ChatColor.RED + "To little args");
						}
					}
				}
				
				if(l.equalsIgnoreCase("getbalance")){
					p.sendMessage(ChatColor.GREEN + "Your balance is now " + e.getBalance(p));
				}
			}
				return false;
		}
}
