package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listener implements org.bukkit.event.Listener{
	//Gadgets
		//Cosmetic
	public Inventory cosmetic;
	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		ItemStack i = new ItemStack(Material.CHEST);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(ChatColor.GREEN + "Cosmetic Menu");
		i.setItemMeta(m);
		
		p.getInventory().setItem(4, i);
	}
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e){
		Action a = e.getAction();
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Cosmetic Menu")){
				cosmetic = Bukkit.createInventory(null, 45);
				
				//Itemstack shit
					//particles
				ItemStack p = new ItemStack(Material.BLAZE_POWDER);
				ItemMeta pm = p.getItemMeta();
				pm.setDisplayName(ChatColor.GOLD + "Particles");
				p.setItemMeta(pm);
				
				//setting up inv
				cosmetic.setItem(10, p);
				
				//giving items
				e.getPlayer().openInventory(cosmetic);
			}
		}
	}
	
	
	
	
}
