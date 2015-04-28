package com.MCNation.bungee;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.md_5.bungee.BungeeCord;

public class Bungee {

	public static boolean isOnline(String s, int p){
		Socket socket = null;
		boolean reachable = false;
		try {
		    socket = new Socket(s , p);
		    reachable = true;
		} catch (UnknownHostException e) {
			reachable = false;
		} catch (IOException e) {
			reachable = false;
			e.printStackTrace();
		} finally {            
		    if (socket != null) try { socket.close(); }catch(IOException e) {}
		}
		return reachable;
	}
	
}
