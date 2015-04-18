package com.MCNation.economy;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.MCNation.hub.Main;

public class Economy extends JavaPlugin{
	
	
	private FileConfiguration efc = null;
	private File ef = null;
	
	public void reloadEconConfig() {
	    if (ef == null) {
	    ef = new File(getDataFolder(), "econ.yml");
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
		System.out.println("works");
		
	    if (efc == null || ef == null) {
	        return;
	    }
	    try {
	        getEconConfig().save(ef);
	    } catch (IOException ex) {
	        System.out.println("Cannot save config " + ef);
	    }
	}
	
	public void setBalance(Player p,int m){
		Main main = new Main();
		System.out.println("----");
		FileConfiguration c = getEconConfig();
		c.set(p.getName(), m);
		saveEconConfig();
	}
	
	public int getBalance(Player p){
		Main main = new Main();
		FileConfiguration c = getEconConfig();
		return (int) c.get(p.getName());
	}
	
	public void addPlayer(Player p){
		
		Main main = new Main();
		FileConfiguration c = getEconConfig();
		if(c.get(p.getName()) == null){
			c.set(p.getName(), "0");
			saveEconConfig();
		}
	}
	
	public void subtractBalance(Player p, int a){
		
		Main main = new Main();
		FileConfiguration c = getEconConfig();
		c.set(p.getName(), c.getInt(p.getName()) - a);
		saveEconConfig();
	}
	
	public void addBalance(Player p, int a){
		Main main = new Main();
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
						setBalance(p, Integer.parseInt(args[0]));
					}else if(args.length == 2){
						if(Bukkit.getPlayer(args[1]) != null){
							setBalance(Bukkit.getPlayer(args[1]), Integer.parseInt(args[0]));
						}else{
							p.sendMessage(ChatColor.RED + "That player does not exist");
						}
					}else{
						p.sendMessage(ChatColor.RED + "To little args");
					}
				}
			}
			
			if(l.equalsIgnoreCase("getbalance")){
				p.sendMessage(ChatColor.GREEN + "Your balance is now " + getBalance(p));
			}
			
			return false;
	}
	
}
