package com.github.JHXSMatthew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import com.huskehhh.mysql.mysql.MySQL;

public class BossBarSQL {
	private Connection c =null;
	private MySQL my;
	
	public BossBarSQL(){
	    this.my = new MySQL("192.168.123.2", "3306", "*****", "*****", "*****");
	}
	
	public void openConnection(){
	    try {
			c = my.openConnection();
		} catch (ClassNotFoundException e) {
			System.out.print("Connection error !");
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.print("Connection error !");
			e1.printStackTrace();
		}
	}
	
	
	public void clsoeConnection() throws SQLException{
		this.c.close();
	}
	
	
	public void closeDB() throws SQLException{
		this.my.closeConnection();
	}
	
	public int getWhackScore(String name) throws ClassNotFoundException, SQLException{
		if(!this.my.checkConnection()){
			this.c = this.my.openConnection();
		}
		Statement s = this.c.createStatement();
		ResultSet result = s.executeQuery("SELECT `score` FROM `WackAmole` Where `name`='"+name+"';");
		if(!result.next()){
			return -1;
		}
		int i = result.getInt("score");
		s.close();
		result.close();
		return i;
	}
	public int getWhackRank(String name) throws ClassNotFoundException, SQLException{
		if(!this.my.checkConnection()){
			this.c = this.my.openConnection();
		}
		Statement s = this.c.createStatement();
		ResultSet result = s.executeQuery("SELECT `id` FROM `WackAmoleTop` Where `name`='"+name+"';");
		if(!result.next()){
			return -1;
		}
		int i = result.getInt("id");
		s.close();
		result.close();
		return i;
	}
	
	public List<String> getBossBar() throws ClassNotFoundException, SQLException{
		List<String> list = new ArrayList<String>();
		if(!this.my.checkConnection()){
			this.c = this.my.openConnection();
		}
		Statement s = this.c.createStatement();
		ResultSet result = s.executeQuery("SELECT * FROM `BossBarInfo` Where `id`='0';");
		if(!result.next()){
			return null;

		}
		list.add(result.getString("sidder"));
		
		list.add(result.getString("front"));

		list.add(result.getString("fliker"));
		
		list.add(result.getString("after"));

		
		s.close();
		result.close();
		return list;
		
	}
}
