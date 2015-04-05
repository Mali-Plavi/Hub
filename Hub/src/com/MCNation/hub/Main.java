package com.MCNation.hub;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

		@Override
		public void onEnable() {
			this.getServer().getPluginManager().registerEvents(new Listener(), this);
			this.getConfig().options().copyDefaults(true);
		}
		
		@Override
		public void onDisable() {
			
		}
}
