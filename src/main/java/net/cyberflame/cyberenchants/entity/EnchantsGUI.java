package net.cyberflame.cyberenchants.entity;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.utils.ChatUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class EnchantsGUI {

	// Variables
	private Main main;
	private Manager manager;
	private Inventory inv;
	private String inventory_name;

	// Constructor
	public EnchantsGUI(Main main, Manager manager) {
		this.main = main;
		this.manager = manager;

		inventory_name = ChatUtils.chat(main.getConfig().getString("EnchantingMenu.title"));
		inv = Bukkit.createInventory(null, main.getConfig().getInt("EnchantingMenu.size") * 9);
	}

	public String getInventoryName() {
		return inventory_name;
	}

	public Inventory createGUI() {
		Inventory toReturn = Bukkit.createInventory(null, main.getConfig().getInt("EnchantingMenu.size") * 9,
				inventory_name);

		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.night-vision.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.night-vision.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.strength.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.strength.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.saturation.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.saturation.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.speed.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.speed.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.grind.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.grind.name"))).getCustomEnchantBook());
		inv.setItem(manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name"))).getSlot(),
				manager.getCustomEnchant(TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name"))).getCustomEnchantBook());

		ItemStack fillerItem;
		if (main.getConfig().getBoolean("EnchantingMenu.FillerItem.enchanted")) {
			fillerItem = ItemUtils.createItemByte(main.getConfig().getInt("EnchantingMenu.FillerItem.materialId"),
					main.getConfig().getInt("EnchantingMenu.FillerItem.materialByte"), 1, true,
					ChatUtils.chat(main.getConfig().getString("EnchantingMenu.FillerItem.display-Name")),
					main.getConfig().getStringList("EnchantingMenu.FillerItem.lore"));
		} else {
			fillerItem = ItemUtils.createItemByte(main.getConfig().getInt("EnchantingMenu.FillerItem.materialId"),
					main.getConfig().getInt("EnchantingMenu.FillerItem.materialByte"), 1, false,
					ChatUtils.chat(main.getConfig().getString("EnchantingMenu.FillerItem.display-Name")),
					main.getConfig().getStringList("EnchantingMenu.FillerItem.lore"));
		}

		for (int x = 0; x < 9 * main.getConfig().getInt("EnchantingMenu.size"); x++) {
			if (inv.getItem(x) == null) {
				inv.setItem(x, fillerItem);
			}
		}

		toReturn.setContents(inv.getContents());
		return toReturn;
	}

}
