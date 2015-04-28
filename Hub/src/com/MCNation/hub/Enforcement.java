package com.MCNation.hub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
 
public class Enforcement extends JavaPlugin implements CommandExecutor{
		@SuppressWarnings("unused")
		private Main plugin;
		public Enforcement(Main plugin){
			this.plugin = plugin;
		}
		@SuppressWarnings("deprecation")
		public static boolean Command(CommandSender sender, Command cmd, String commandLabel, String[] args) {
                if (cmd.getName().equalsIgnoreCase("essentials.kick")) {
                	Player p = (Player) sender;
                        if (args.length == 0) {
                                p.sendMessage(ChatColor.RED + "Please specify a player!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                                return true;
                        }
                        target.kickPlayer(ChatColor.RED + "You have been kicked!");
                        Bukkit.getServer().getPluginManager().callEvent(new EnforcementEvent(target, Type.KICK));
                        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Player " + target.getName() + " has been kicked by " + sender.getName() + "!");
                }else{
                	sender.sendMessage(ChatManager.permFormat);
                }
                if (cmd.getName().equalsIgnoreCase("essentials.ban")) {
                        if (args.length == 0) {
                                sender.sendMessage(ChatColor.RED + "Please specify a player!");
                                return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                                sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                                return true;
                        }
                        target.kickPlayer(ChatColor.RED + "You have been banned!");
                        target.setBanned(true);
                        Bukkit.getServer().getPluginManager().callEvent(new EnforcementEvent(target, Type.BAN));
                        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Player " + target.getName() + " has been banned by " + sender.getName() + "!");
                }else{sender.sendMessage(ChatManager.permFormat);}
                return true;
        }
}
