package com.MCNation.economy;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.MCNation.hub.Main;

public class Economy{
	
	public Main plugin;
	
	public Economy(Main plugin){
		this.plugin = plugin;
	}
	
	
	
	private FileConfiguration efc = null;
	private File ef = null;
	
	public void reloadEconConfig() {
	    if (ef == null) {
	    ef = new File(plugin.getDataFolder(), "econ.yml");
	    }
	    efc = YamlConfiguration.loadConfiguration(ef);
	}
	
	
	public FileConfiguration getEconConfig() {
	    if (efc == null) {
	        reloadEconConfig();
	    }
	    return efc;
	}
	
	public void saveEconConfig() {
	    if (efc == null || ef == null) {
	        return;
	    }
	    try {
	        getEconConfig().save(ef);
	    } catch (IOException ex) {
	        System.out.println("Cannot save config " + ef);
	    }
	}
	
	public void setBalance(String p,int m){
		FileConfiguration c = getEconConfig();
		c.set(p, m);
		saveEconConfig();
	}
	
	public int getBalance(String p){
		FileConfiguration c = getEconConfig();
		return (int) c.get(p);
	}
	
	public void addPlayer(Player p){
		FileConfiguration c = getEconConfig();
		if(c.get(p.getName()) == null){
			c.set(p.getName(), "0");
			saveEconConfig();
		}
	}
	
	public void subtractBalance(String p, int a){
		FileConfiguration c = getEconConfig();
		c.set(p, c.getInt(p) - a);
		saveEconConfig();
	}
	
	public void addBalance(Player p, int a){
		FileConfiguration c = getEconConfig();
		c.set(p.getName(), c.getInt(p.getName()) + a);
		saveEconConfig();
	}
	
	//commandstuff
	public boolean Command(CommandSender sender, Command cmd, String l, String[] args) {
		Player p = (Player) sender;
			
			if(l.equalsIgnoreCase("setbalance")){
				if(p.hasPermission("economy.change")){
					if(args.length == 1){
						setBalance(p.getName(), Integer.parseInt(args[0]));
						p.sendMessage(ChatColor.GREEN + "Your balance is now " + args[0]);
					}else if(args.length == 2){
							setBalance(args[1], Integer.parseInt(args[0]));
							p.sendMessage(ChatColor.GREEN + args[1] + "'s Balance is now " + args[0]);
					}else{
						p.sendMessage(ChatColor.RED + "To little args");
					}
				}
			}
			
			if(l.equalsIgnoreCase("getbalance")){
				p.sendMessage(ChatColor.GREEN + "Your balance is now " + getBalance(p.getName()));
			}
			
			return false;
	}
	
}
