package net.cyberflame.cyberenchants.hook;

import org.bukkit.Bukkit;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.utils.ChatUtils;
import net.md_5.bungee.api.ChatColor;

public class FactionsHook {

	public static void hook(Main main) {
		if (Bukkit.getPluginManager().getPlugin("Factions") != null) {
			main.factionsPlugin = Bukkit.getPluginManager().getPlugin("Factions");
			if (main.factionsPlugin.getDescription().getVersion().startsWith("1.6")) {
				main.factionsType = FactionsTypeEnum.FactionsUUID;
			}
			ChatUtils.tellConsole(ChatColor.GOLD + "[CyberEnchants] Hooking into Factions...");
		} else {
			main.factionsType = FactionsTypeEnum.None;
			ChatUtils.tellConsole(ChatColor.GOLD + "[CyberEnchants] A Factions plugin has not been detected!");
		}
	}
	
}
