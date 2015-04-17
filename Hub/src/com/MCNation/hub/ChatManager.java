package com.MCNation.hub;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager {
	
public static void onChat(AsyncPlayerChatEvent e){
	Player p = e.getPlayer();
		if(p.hasPermission("rank.guide")){
			e.setFormat(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.DARK_GRAY +  "> " + ChatColor.GRAY + e.getMessage());
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
		//else if(){
			
		//}
	}

}
