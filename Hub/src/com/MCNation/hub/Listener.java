package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.MCNation.gadgets.Pets;

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
			if(e.getPlayer().getItemInHand().getItemMeta() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Cosmetic Menu")){
					cosmetics(e.getPlayer());
				}}
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
	
	public void pa(Player p){
		ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta bkm = bk.getItemMeta();
		bkm.setDisplayName(ChatColor.GOLD + "Back");
		bk.setItemMeta(bkm);
		
		pe = Bukkit.createInventory(null, 45+9, "Particles");
		pe.setItem(45, bk);
		p.closeInventory();
		p.openInventory(pe);
		return;
		
	}
	
	public void pe(Player p){
		ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta bkm = bk.getItemMeta();
		bkm.setDisplayName(ChatColor.GOLD + "Back");
		bk.setItemMeta(bkm);
		
		pe = Bukkit.createInventory(null, 45+9, "Pets");
		pe.setItem(45, bk);
		addPets();
		p.openInventory(pe);
	}
	
	public void ga(Player p){
		ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta bkm = bk.getItemMeta();
		bkm.setDisplayName(ChatColor.GOLD + "Back");
		bk.setItemMeta(bkm);
		
		g = Bukkit.createInventory(null, 45+9, "Gadgets");g.setItem(45, bk);
		p.openInventory(g);
	}
	public void wa(Player p){
		ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta bkm = bk.getItemMeta();
		bkm.setDisplayName(ChatColor.GOLD + "Back");
		bk.setItemMeta(bkm);
		
		w = Bukkit.createInventory(null, 45+9, "Wardrobe");w.setItem(45, bk);
		p.openInventory(w);
	}
	
	public void mo(Player p){
		ItemStack bk = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta bkm = bk.getItemMeta();
		bkm.setDisplayName(ChatColor.GOLD + "Back");
		bk.setItemMeta(bkm);
		
		m = Bukkit.createInventory(null, 45+9, "Mounts");m.setItem(45, bk);
		p.openInventory(m);
	}
	
			//the thing for when you click in inv
	@SuppressWarnings("unused")
	@EventHandler
	public void invInteract(InventoryClickEvent e){
		if(e.getCurrentItem() != null){
		if(e.getCurrentItem().getItemMeta() != null){
		String name = e.getInventory().getName();
		Player p = (Player) e.getWhoClicked();
		
			if(e.getInventory().getName().contains("Cosmetic Menu")){
				
				if(e.getCurrentItem().getItemMeta().getDisplayName() != null)				//particles
				if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Particles")){
					e.setCancelled(true);
						pa(p);
						return;
				}
				//pets
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Pets")){
					e.setCancelled(true);
					pe(p);
				}
				//gadgets
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Gadgets")){
					e.setCancelled(true);
					ga(p);
				}
				//wardrobe
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Wardrobe")){
					e.setCancelled(true);
					wa(p);
					}
				//mounts
				else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Mounts")){
					e.setCancelled(true);
					mo(p);
						}
			}
			String n = e.getInventory().getName();
			if(n.contains("Particles")||n.contains("Pets")||n.contains("Gadgets")||n.contains("Wardrobe")||n.contains("Mounts")){
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Back")){
				e.setCancelled(true);
				cosmetics(p);
			}}}}
			
		}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		e.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + player.getName());
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent l) {
		Player player = l.getPlayer();
		l.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + player.getName());
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		ChatManager.onChat(e);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if(e.getPlayer().hasPermission("blocks.change")){
			return;
		}else{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e){
		if(e.getPlayer().hasPermission("blocks.change")){
			if(e.getPlayer().getItemInHand().getItemMeta() != null){
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null){
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("Cosmetic Menu")){
						e.setCancelled(true);
					}
				}return;
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("items.drop")){
			if(e.getItemDrop().getItemStack().getItemMeta() != null){
				if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName() != null){
					if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Cosmetic Menu")){
						e.setCancelled(true);
					}
				}
			}
			return;
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void weatherChangeEvent(WeatherChangeEvent e){
		if(e.toWeatherState()){
			e.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void addPets(){
		ItemStack wolf = new ItemStack(Material.MONSTER_EGG, 1, (short) 0, (byte) 95);
		ItemMeta wm = wolf.getItemMeta();
		wm.setDisplayName(ChatColor.GOLD + "Wolf");
		wolf.setItemMeta(wm);
		
		pe.setItem(10, wolf);
	}
	@EventHandler
	public void clickPets(InventoryClickEvent e){
		if(e.getCurrentItem().getItemMeta() != null){
			if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
				if(e.getInventory().getName() != null){
					if(e.getInventory().getName().contains("Pets")){
						if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Wolf")){
							e.getWhoClicked().sendMessage("you did it");
							e.setCancelled(true);
							Pets.setPet((Player) e.getWhoClicked(), EntityType.WOLF);
						}
					}
				}
			}
		}
	}
}
