package com.MCNation.hub;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager {
	
public static void onChat(AsyncPlayerChatEvent e){
	Player p = e.getPlayer();
	if(p.isOp()){
		e.setFormat(ChatColor.GRAY + e.getPlayer().getCustomName() + ChatColor.DARK_GRAY +  "> " + ChatColor.GRAY + e.getMessage());
	}else{
			if(p.hasPermission("rank.guide")){
			
			}else if(p.hasPermission("rank.mod")){
			
			}else if(p.hasPermission("rank.mod+")){
			
			}else if(p.hasPermission("rank.admin")){
			
			}else if(p.hasPermission("rank.admin+")){
			
			}else if(p.hasPermission("rank.owner")){
			
			}else if(p.hasPermission("rank.build")){
			
			}else if(p.hasPermission("rank.build+")){
			
			}else if(p.hasPermission("rank.art")){
			
			}else if(p.hasPermission("rank.dev")){
			
			}
	
		//player ranks
			else if(p.hasPermission("rank.gamer")){
			
			}else if(p.hasPermission("rank.vip")){
			
			}else if(p.hasPermission("rank.ultra")){
			
			}else if(p.hasPermission("rank.legend")){
			
			}else if(p.hasPermission("rank.supreme")){
			
			}else if(p.hasPermission("rank.ultimate")){
			
			}else if(p.hasPermission("rank.yt")){
			
			}else if(p.hasPermission("rank.ogs")){
			
			}else{
				e.setFormat(ChatColor.GRAY + e.getPlayer().getCustomName() + ChatColor.DARK_GRAY +  "> " + ChatColor.GRAY + e.getMessage());
			}
		}
	}

}
