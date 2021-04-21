package net.cyberflame.cyberenchants.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatUtils {

	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

	public static void tellConsole(String message) {
		Bukkit.getConsoleSender().sendMessage(chat(message));
	}

}
