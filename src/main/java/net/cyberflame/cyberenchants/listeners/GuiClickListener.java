package net.cyberflame.cyberenchants.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.CustomEnchant;
import net.cyberflame.cyberenchants.entity.EnchantsGUI;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ChatUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class GuiClickListener implements Listener {

	// Variables
	private Main plugin;
	private EnchantsGUI enchantsGUI;
	private Manager manager;

	// Constructor
	public GuiClickListener(Main main, EnchantsGUI enchantsGUI, Manager manager) {
		this.plugin = main;
		this.enchantsGUI = enchantsGUI;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	// Events
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player))
			return;

		Player player = (Player) event.getWhoClicked();
		String inventoryTitle = event.getInventory().getTitle();

		if (inventoryTitle.equals(enchantsGUI.getInventoryName())) {
			event.setCancelled(true);

			ItemStack itemClicked = event.getCurrentItem();
			if (itemClicked == null)
				return;

			for (CustomEnchant enchantment : manager.getListCustomEnchants()) {
				if (enchantment.getCustomEnchantBook().equals(itemClicked)) {
					ItemStack itemToGive = createItemBought(enchantment.getName());
					int cost = enchantment.getCost();

					if (player.getLevel() >= cost) {
						ItemUtils.giveItem(player, itemToGive);
						player.setLevel(player.getLevel() - cost);
						player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1, 1);
					} else {
						player.sendMessage(ChatUtils.chat("&cYou don't have enough experience."));
					}
					return;
				}
			}
		}
	}

	public ItemStack createItemBought(String enchantmentName) {
		ItemStack itemToGive = null;
		List<String> customEnchantLore = new ArrayList<String>();
		
		if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.water-breathing.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}
			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.night-vision.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.strength.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.strength.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.strength.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.saturation.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.saturation.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.saturation.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.fire-resistance.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.speed.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.speed.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.speed.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.jelly-legs.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.grind.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.grind.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.grind.name")),
					customEnchantLore);
		} else if (enchantmentName.contains(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")))) {
			for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.obsidian-breaker.lore")) {
				if (!(lineLore.contains("{cost}") || lineLore.contains("{remove-item}"))) {
					customEnchantLore.add(lineLore);
				}
			}

			itemToGive = ItemUtils.createItem(403, 1, true,
					ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")),
					customEnchantLore);
		}

		return itemToGive;
	}
}
