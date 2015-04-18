package com.MCNation.economy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.MCNation.hub.Main;

public class Economy {
	
	private static Main main = new Main();
	
	private FileConfiguration c = main.getEconConfig();
	
	public void setBalance(Player p,int m){
		c.set(p.getName(), m);
		main.saveEconConfig();
	}
	
	public int getBalance(Player p){
		return (int) c.get(p.getName());
	}
	
	public void addPlayer(Player p){
		if(c.get(p.getName()) == null){
			c.set(p.getName(), "0");
			main.saveEconConfig();
		}
	}
	
	public void subtractBalance(Player p, int a){
		c.set(p.getName(), c.getInt(p.getName()) - a);
		main.saveEconConfig();
	}
	
	public void addBalance(Player p, int a){
		c.set(p.getName(), c.getInt(p.getName()) + a);
		main.saveEconConfig();
	}
}
