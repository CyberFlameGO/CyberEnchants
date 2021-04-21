package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class InventoryClickListener implements Listener {

	// Variables
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public InventoryClickListener(Main main, Manager manager) {
		super();
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	//Events
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		ItemStack itemClicked = event.getCurrentItem();
		ItemStack itemCursor = event.getCursor();

		if (itemClicked == null || itemCursor == null)
			return;

		if (itemCursor.getTypeId() != 403)
			return;
		
		if (ArmorUtils.isHelmet(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.display-Name")));
				}
			} else if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.night-vision.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.night-vision.display-Name")));
				}
			}
		} else if (ArmorUtils.isChestplate(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.saturation.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.saturation.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.saturation.display-Name")));
				}
			} else if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.strength.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.strength.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.strength.display-Name")));
				}
			}
		} else if (ArmorUtils.isLeggings(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.display-Name")));
				}
			}
		} else if (ArmorUtils.isBoots(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.speed.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.speed.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.speed.display-Name")));
				}
			} else if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.display-Name")));
				}
			}
		} else if (ArmorUtils.isSword(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.grind.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.grind.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.grind.display-Name")));
				}
			}
		} else if (ArmorUtils.isPickaxe(itemClicked)) {
			if (itemCursor.getItemMeta().getDisplayName().contains(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")))) {
				if (!ItemUtils.itemLoreHasString(itemClicked, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.display-Name")))) {
					applyBook(event, ItemUtils.addStringToItemLore(itemClicked, main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.display-Name")));
				}
			}
		}
		
	}

	public void applyBook(InventoryClickEvent event, ItemStack itemStack) {
		event.getWhoClicked().setItemOnCursor(null);
		event.setCurrentItem(itemStack);
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
	}

}
