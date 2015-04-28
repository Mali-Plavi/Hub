package com.MCNation.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creature;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.util.Vector;

import com.MCNation.hub.Main;

public class Bossbar {
	public Main plugin;
	
		public Bossbar(Main plugin){
			this.plugin = plugin;
		}
	@SuppressWarnings("deprecation")
	public void SpawnBossbar(String Name, Double perscentofhealth){
		killBossbar();
		if(perscentofhealth > 100){
			return;
		}
		Main Main = new Main();
		Location l = (Location) Main.getConfig().get("spawn");
		l.subtract(0, 50, 0);
		EnderDragon c = Bukkit.getWorld("world").spawn(l, EnderDragon.class);
		c.setCustomName(Name);
		c.setHealth(perscentofhealth*2);
	}
	
	public void killBossbar(){
		Main Main = new Main();
		Location l = (Location) Main.getConfig().get("spawn");
		Bukkit.getWorld("world").getEntities();
	}
	
}
