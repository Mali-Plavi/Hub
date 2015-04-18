package com.MCNation.chat;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.MCNation.hub.Main;
import com.avaje.ebeaninternal.server.autofetch.TunedQueryInfo;

public class Nicknames implements Listener{
	
	public static Main plugin;
	
	private static FileConfiguration efc = null;
	private static File ef = null;
	
	public static void reloadNickConfig() {
	    if (ef == null) {
	    ef = new File(plugin.getDataFolder(), "nick.yml");
	    }
	    efc = YamlConfiguration.loadConfiguration(ef);
	}
	
	
	public static FileConfiguration getNickConfig() {
	    if (efc == null) {
	        reloadNickConfig();
	    }
	    return efc;
	}
	
	public void saveNickConfig() {
	    if (efc == null || ef == null) {
	        return;
	    }
	    try {
	        getNickConfig().save(ef);
	    } catch (IOException ex) {
	        System.out.println("Cannot save config " + ef);
	    }
	}
	
	public Nicknames(Main plugin){
		this.plugin = plugin;
	}
	
	public static void changeNickname(Player p, String s){
		s = s.replace("&", "§");
		p.setCustomName(s);
		p.setCustomNameVisible(true);
	}
	
	public static void turnNicknameOff(Player p){
		p.setCustomName(p.getName());
	}
	
	public static boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		Player p = (Player) sender;
		if(l.equalsIgnoreCase("nick")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("off")){
					turnNicknameOff(p);
					p.sendMessage(ChatColor.GREEN + "You turned off your nickname");
					return true;
				}else{
					changeNickname(p, args[0]);
					p.sendMessage(ChatColor.GREEN + "Your new nickname is " + args[0].replace("&", "§"));
					return true;
				}
			}else if(args.length == 2){
				if(Bukkit.getPlayer(args[1]) != null){
					if(args[0].equals("off")){
						turnNicknameOff(p);
						p.sendMessage(ChatColor.GREEN + "You turned off " + args[1] + "'s nickname");
						return true;
					}else{
						changeNickname(Bukkit.getPlayer(args[1]), args[0]);
						p.sendMessage(ChatColor.GREEN + args[1] + "'s new nickname is " + args[0].replace("&", "§"));
						return true;
					}
				}else{
					p.sendMessage(ChatColor.RED + "That player does not exist");
				}
			}
		}
		
		return false;
	}
}
