package com.github.JHXSMatthew;

import org.bukkit.plugin.java.JavaPlugin;

public class BossBarSender extends JavaPlugin {
	public static BossBarSQL sql ;
	private static BossBarSender instance;
	private BossBarController bc ;
	
	
	public void onEnable(){
		sql = new BossBarSQL();
		sql.openConnection();
		instance = this;
		
		
		bc = new BossBarController();
	}
	
	public static BossBarSender get(){
		return instance;
	}
	
	public BossBarController getBc(){
		return bc;
	}
	
	public void startSending(){
		if(bc == null){
			bc = new BossBarController();
		}
		StopSending();
		bc.register();
	}
	
	public void StopSending(){
		if(bc != null){
			bc.cancel();
		}
		
	}
}
