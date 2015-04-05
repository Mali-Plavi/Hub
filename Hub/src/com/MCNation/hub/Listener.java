package com.MCNation.hub;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listener implements org.bukkit.event.Listener{
	//Gadgets
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		ItemStack i = new ItemStack(Material.CHEST);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(Color.LIME + "Cosmetic Menu");
		i.setItemMeta(m);
		
		p.getInventory().setItem(4, i);
	}
	
	
}
