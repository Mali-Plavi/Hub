package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobSpawning {

	public static void onSpawn(CreatureSpawnEvent e){
		LivingEntity c = e.getEntity();
		e.getEntity().remove();
	}
	
	@SuppressWarnings("deprecation")
	public void SpawnMob(EntityType e, String name, Location l){
		if(name != null){
			LivingEntity le = Bukkit.getWorld("world").spawnCreature(l, e);
			le.setCustomName(name);
			le.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
		}else{
			Bukkit.getWorld("world").spawnCreature(l, e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void SpawnMob(EntityType e, String name, double x, double y, double z){
		if(name != null){
			Location a = new Location(Bukkit.getWorld("world"),x ,y ,z);
			LivingEntity le = Bukkit.getWorld("world").spawnCreature(a, e);
			le.setCustomName(name);
			le.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));
		}else{
			Location a = new Location(Bukkit.getWorld("world"),x ,y ,z);
			Bukkit.getWorld("world").spawnCreature(a, e);
		}
	}
}
