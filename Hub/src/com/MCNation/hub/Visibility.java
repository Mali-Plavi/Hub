package com.MCNation.hub;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Visibility {

public Main plugin;
	
	public Visibility(Main plugin){
		this.plugin = plugin;
	}
	
	//if player is visible, true=visible, false=invisible
	public static HashMap<Player, Boolean> v = new HashMap<Player, Boolean>();
	
	public static void onThrow(PlayerDropItemEvent e){
		ItemStack i = e.getItemDrop().getItemStack();
		if(i.getItemMeta() != null){
			if(i.getItemMeta().getDisplayName() != null){
				if(i.getItemMeta().getDisplayName().contains("Visibility")){
					e.setCancelled(true);
				}
			}
		}
	}
	
	public static void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		ItemStack is = new ItemStack(Material.SLIME_BALL);
		ItemMeta i = is.getItemMeta();
		i.setDisplayName(ChatColor.GREEN + "Visibility" + ChatColor.WHITE + " - " + ChatColor.GREEN + "Shown");
		is.setItemMeta(i);
		
		p.getInventory().setItem(0, is);
		
		v.put(p, true);
		
		for(Player all : Bukkit.getOnlinePlayers()){
			if(v.get(all) == true){
			all.showPlayer(p);
			p.showPlayer(all);
			}
		}
	}
	
	public static void onClick(PlayerInteractEvent e){
		Action a = e.getAction();
		Player p = e.getPlayer();
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK || a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK){
			if(e.getPlayer().getItemInHand().getItemMeta() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Visibility")){
						if(v.get(p) != null){
							if(v.get(p) == true){
								v.put(p, false);
								for(Player all : Bukkit.getOnlinePlayers()){
									all.hidePlayer(p);
									p.hidePlayer(all);
								}
								ItemStack is = new ItemStack(Material.MAGMA_CREAM);
								ItemMeta i = is.getItemMeta();
								i.setDisplayName(ChatColor.GREEN + "Visibility" + ChatColor.WHITE + " - " + ChatColor.RED + "Hidden");
								is.setItemMeta(i);
								
								p.setItemInHand(is);
							}else{
								v.put(p, true);
								for(Player all : Bukkit.getOnlinePlayers()){
									all.showPlayer(p);
									p.showPlayer(all);
								}
								
								
								ItemStack is = new ItemStack(Material.SLIME_BALL);
								ItemMeta i = is.getItemMeta();
								i.setDisplayName(ChatColor.GREEN + "Visibility" + ChatColor.WHITE + " - " + ChatColor.GREEN + "Shown");
								is.setItemMeta(i);
								p.setItemInHand(is);
							}
						}else{
							v.put(p, false);
							for(Player all : Bukkit.getOnlinePlayers()){
								all.hidePlayer(p);
								p.hidePlayer(all);
							}
							ItemStack is = new ItemStack(Material.MAGMA_CREAM);
							ItemMeta i = is.getItemMeta();
							i.setDisplayName(ChatColor.GREEN + "Visibility" + ChatColor.WHITE + " - " + ChatColor.RED + "Hidden");
							is.setItemMeta(i);
							
							p.setItemInHand(is);
						}
					}
				}
			}
		}
	}
	
}
