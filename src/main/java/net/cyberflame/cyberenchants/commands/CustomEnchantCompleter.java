package net.cyberflame.cyberenchants.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ChatUtils;

public class CustomEnchantCompleter implements TabCompleter {

	// Variables
	@SuppressWarnings("unused")
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructors
	public CustomEnchantCompleter(Main main, Manager manager) {
		super();
		this.main = main;
		this.manager = manager;

		main.getCommand("ce").setTabCompleter(this);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

		List<String> listTabulations = null;

		if (args.length == 1) {
			listTabulations = new ArrayList<>();
			listTabulations.add("give");
			listTabulations.add("reload");
		} else if (args.length == 3) {
			listTabulations = new ArrayList<>();
			listTabulations.add(ChatUtils.chat("&7fireresistance"));
			listTabulations.add(ChatUtils.chat("&7saturation"));
			listTabulations.add(ChatUtils.chat("&7nightvision"));
			listTabulations.add(ChatUtils.chat("&7waterbreathing"));
			listTabulations.add(ChatUtils.chat("&7speed"));
			listTabulations.add(ChatUtils.chat("&7strength"));
			listTabulations.add(ChatUtils.chat("&7jellylegs"));
			listTabulations.add(ChatUtils.chat("&7grind"));
			listTabulations.add(ChatUtils.chat("&7obsidianbreaker"));
		}

		return listTabulations;
	}

}
