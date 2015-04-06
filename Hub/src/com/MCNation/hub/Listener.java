package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Listener implements org.bukkit.event.Listener{
	//Gadgets
		//Cosmetic
	public Inventory cosmetic, pa, pe, g,w,m;
	
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
			if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Cosmetic Menu")){
					cosmetics(e.getPlayer());
				}
			}
		}
	}
	public void cosmetics(Player pl){
		cosmetic = Bukkit.createInventory(null,54,"Cosmetic Menu");
		
		
		//Itemstack shit
			//particles
		ItemStack p = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta pm = p.getItemMeta();
		pm.setDisplayName(ChatColor.GOLD + "Particles");
		p.setItemMeta(pm);
			//pets
		ItemStack pe = new ItemStack(Material.BONE);
		ItemMeta pem = p.getItemMeta();
		pem.setDisplayName(ChatColor.GOLD + "Pets");
		pe.setItemMeta(pem);
			//gadgets
		ItemStack g = new ItemStack(Material.BOW);
		ItemMeta gm = p.getItemMeta();
		gm.setDisplayName(ChatColor.GOLD + "Gadgets");
		g.setItemMeta(gm);
			//wardrobe
		ItemStack w = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta wml = (LeatherArmorMeta) w.getItemMeta();
		wml.setColor(Color.WHITE);
		wml.setDisplayName(ChatColor.GOLD + "Wardrobe");
		w.setItemMeta(wml);
			//mounts
		ItemStack m = new ItemStack(Material.SADDLE);
		ItemMeta mm = p.getItemMeta();
		mm.setDisplayName(ChatColor.GOLD + "Mounts");
		m.setItemMeta(mm);
		
		//setting up inv
		cosmetic.setItem(10+9*2-1, p);
		cosmetic.setItem(12+9*2-1, pe);
		cosmetic.setItem(14+9*2-1, g);
		cosmetic.setItem(16+9*2-1, w);
		cosmetic.setItem(29+6, m);
		
		//giving items
		pl.openInventory(cosmetic);
	}
	
			//the thing for when you click in inv
	@EventHandler
	public void invInteract(InventoryClickEvent e){
		if(e.getCurrentItem().getItemMeta() != null){
		String name = e.getInventory().getName();
		Player p = (Player) e.getWhoClicked();
		
			if(e.getInventory().getName().contains("Cosmetic Menu")){
				ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
				ItemMeta bkm = bk.getItemMeta();
				bkm.setDisplayName(ChatColor.GOLD + "Back");
				bk.setItemMeta(bkm);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName() != null)				//particles
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Particles")){
						pa = Bukkit.createInventory(null, 45+9, "Particles");
						pa.setItem(45, bk);
						p.closeInventory();
						p.openInventory(pa);
						return;
				}
				//pets
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Pets")){
					pe = Bukkit.createInventory(null, 45+9, "Pets");
					pe.setItem(45, bk);
					p.openInventory(pe);
				}
				//gadgets
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Gadgets")){
					g = Bukkit.createInventory(null, 45+9, "Gadgets");pa.setItem(45, bk);
					p.openInventory(g);
				}
				//wardrobe
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Wardrobe")){
					w = Bukkit.createInventory(null, 45+9, "Wardrobe");pa.setItem(45, bk);
					p.openInventory(w);
					}
				//mounts
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Mounts")){
						m = Bukkit.createInventory(null, 45+9, "Mounts");pa.setItem(45, bk);
						p.openInventory(m);
						}
			}
		}
	}
	
	@EventHandler
	public void interact(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		String name = e.getInventory().getName();
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Back")){
			cosmetics(p);
}
	}
}
