package com.github.JHXSMatthew;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.inventivetalent.bossbar.BossBarAPI;


public class BossBarController {
	public BukkitTask task = null;
	private List<String> current ;
	
	
	
	String sidder =  "☀ ";
	String fliker = "YourCraft-你的世界 ";
	String front = "欢迎来到 ";
	String after = "请访问 www.mcndsj.com ";
	
	
	
	public BossBarController(){
		
		register();

	}
	
	public void register(){
		try {
			List<String> s = BossBarSender.sql.getBossBar();
			if(s != null && s.size() == 4){
				sidder = s.get(0);
				front = s.get(1);
				fliker = s.get(2);
				after = s.get(3);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		current = flickEffect(ChatColor.WHITE, ChatColor.WHITE, ChatColor.GREEN , ChatColor.RED, ChatColor.YELLOW);
		task  = new BukkitRunnable(){
			int count = 0;
			@Override
			public void run() {
				if(count < current.size() -1){
					count ++;
				}else{
					count = 0;
				}
				
				for(Player p : Bukkit.getOnlinePlayers()){
					BossBarAPI.setMessage(p, current.get(count));
				}
				
			}
			
		}.runTaskTimerAsynchronously(BossBarSender.get(),0 ,5);
		//rainBow
		// rainBowEffect();
	}
	
	public void cancel(){
		if(task != null){
			task.cancel();
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			BossBarAPI.removeBar(p);
		}
		
	}
	
	private List<String> rainBowEffect(String string){
		List<String> returnValue =  new ArrayList<String>();
		returnValue.add(ChatColor.RED + string);
		returnValue.add(ChatColor.GOLD + string);
		returnValue.add(ChatColor.YELLOW + string);
		returnValue.add(ChatColor.GREEN + string);
		returnValue.add(ChatColor.BLUE + string);
		returnValue.add(ChatColor.AQUA + string);
		returnValue.add(ChatColor.LIGHT_PURPLE + string);
		
		return returnValue;
	}
	
	private List<String> flickEffect(ChatColor sidder , ChatColor flikerFrom, ChatColor flikerTo, ChatColor front , ChatColor after){
		List<String> returnValue =  new ArrayList<String>();
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		
		for(int i = 0; i < fliker.length() ; i ++){
			String tempFront = fliker.substring(0, i);
			String tempAfter = fliker.substring(i,fliker.length());
			String realFliker = flikerTo + ChatColor.BOLD.toString()+ tempFront + flikerFrom  + ChatColor.BOLD.toString()+tempAfter;
			returnValue.add(sidder + this.sidder + front + this.front +  realFliker + after + this.after+ sidder + this.sidder);
		}
		

		
		returnValue.add(sidder + this.sidder + front + this.front + flikerTo  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerTo  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerTo  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerTo  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerTo  + ChatColor.BOLD.toString()+ this.fliker + after + this.after+ sidder + this.sidder);
		
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom  + ChatColor.BOLD.toString()+ this.fliker + after + this.after + sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom  + ChatColor.BOLD.toString()+ this.fliker + after + this.after + sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom  + ChatColor.BOLD.toString()+ this.fliker + after + this.after + sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom  + ChatColor.BOLD.toString()+ this.fliker + after + this.after + sidder + this.sidder);
		returnValue.add(sidder + this.sidder + front + this.front + flikerFrom + ChatColor.BOLD.toString()+ this.fliker + after + this.after + sidder + this.sidder);
		
		
		
		return returnValue;

	}
	
}
