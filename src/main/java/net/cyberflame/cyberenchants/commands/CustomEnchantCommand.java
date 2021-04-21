package net.cyberflame.cyberenchants.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.EnchantsGUI;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ChatUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;

public class CustomEnchantCommand implements CommandExecutor {

	// Variables
	private Main plugin;
	private Manager manager;
	private EnchantsGUI enchantsGUI;

	// Constructors
	public CustomEnchantCommand(Main plugin, Manager manager, EnchantsGUI enchantsGUI) {
		super();
		this.plugin = plugin;
		this.manager = manager;
		this.enchantsGUI = enchantsGUI;

		plugin.getCommand("ce").setExecutor(this);
	}

	// Events
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player))
			return false;

		Player player = (Player) sender;

		if (args.length == 0) {

			player.openInventory(enchantsGUI.createGUI());
		} else if (args.length == 1 && args[0].equals("reload")) {

			if (!player.hasPermission("cyberenchants.reload")) {
				player.sendMessage(ChatUtils.chat("&cYou don't have permission to execute this command!"));
				return false;
			}
			
			plugin.reloadConfig();
			
			manager.restartCustomEnchantList();
			manager.addCustomEnchant(manager.createFireResistanceBook());
			manager.addCustomEnchant(manager.createSaturationBook());
			manager.addCustomEnchant(manager.createNightVisionBook());
			manager.addCustomEnchant(manager.createWaterBreathingBook());
			manager.addCustomEnchant(manager.createSpeedBook());
			manager.addCustomEnchant(manager.createStrengthBook());
			manager.addCustomEnchant(manager.createJellyLegsBook());
			manager.addCustomEnchant(manager.createGrindBook());
			manager.addCustomEnchant(manager.createObsidianBreakerBook());
			
			enchantsGUI = new EnchantsGUI(plugin, manager);

			player.sendMessage(ChatUtils.chat("&7CyberEnchants' configuration has been reloaded."));
		} else if (args.length == 3 && args[0].equals("give")) {
			
			if (!player.hasPermission("cyberenchants.give")) {
				player.sendMessage(ChatUtils.chat("&cYou don't have permission to execute this command!"));
				return false;
			}
			
			Player givePlayer = Bukkit.getPlayer(args[1]);

			if (givePlayer == null) {
				player.sendMessage(ChatUtils.chat("&4No player was found with that name."));
			}

			ItemStack itemToGive = null;
			List<String> customEnchantLore = new ArrayList<String>();

			switch (args[2]) {
			case "waterbreathing":
				for (String lineLore : plugin.getConfig()
						.getStringList("EnchantingMenu.Enchants.water-breathing.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")),
						customEnchantLore);
				break;
			case "nightvision":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.night-vision.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")),
						customEnchantLore);
				break;
			case "strength":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.strength.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.strength.name")),
						customEnchantLore);
				break;
			case "saturation":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.saturation.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.saturation.name")),
						customEnchantLore);
				break;
			case "fireresistance":
				for (String lineLore : plugin.getConfig()
						.getStringList("EnchantingMenu.Enchants.fire-resistance.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")),
						customEnchantLore);
				break;
			case "speed":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.speed.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.speed.name")),
						customEnchantLore);
				break;
			case "jellylegs":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.jelly-legs.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")),
						customEnchantLore);
				break;
			case "grind":
				for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.grind.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.grind.name")),
						customEnchantLore);
				break;
			case "obsidianbreaker":
				for (String lineLore : plugin.getConfig()
						.getStringList("EnchantingMenu.Enchants.obsidian-breaker.lore")) {
					if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
						customEnchantLore.add(lineLore);
					}
				}

				itemToGive = ItemUtils.createItem(403, 1, true,
						ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")),
						customEnchantLore);
				break;
			default:
				player.sendMessage(ChatUtils.chat("&cThere is no custom enchant with name " + args[2]));
				break;
			}

			if (itemToGive != null) {
				ItemUtils.giveItem(givePlayer, itemToGive);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
			}

		}
		return true;
	}

    

}
