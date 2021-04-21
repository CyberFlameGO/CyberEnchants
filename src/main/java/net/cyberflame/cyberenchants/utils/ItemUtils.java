package net.cyberflame.cyberenchants.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

	public static ItemStack createItemWithoutLore(int materialId, int amount, boolean enchanted, String displayName) {

		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(materialId), amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}


	public static ItemStack createItem(int materialId, int amount, boolean enchanted, String displayName,
			String... loreString) {

		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(materialId), amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}


	public static ItemStack createItem(Material material, int amount, boolean enchanted, String displayName,
			String... loreString) {

		ItemStack item = new ItemStack(material, amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack createItemByte(int materialId, int byteId, int amount, boolean enchanted,
			String displayName, String... loreString) {

		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(materialId), amount, (short) byteId);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack createItemByte(int materialId, int byteId, int amount, boolean enchanted,
			String displayName, List<String> loreString) {

		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(materialId), amount, (short) byteId);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}

    
	public static ItemStack createItem(Material material, int amount, boolean enchanted, String displayName,
			List<String> loreString) {

		ItemStack item = new ItemStack(material, amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}


	public static ItemStack createItem(int materialId, int amount, boolean enchanted, String displayName,
			List<String> loreString) {

		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(materialId), amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatUtils.chat(displayName));
		List<String> lore = new ArrayList<String>();
		for (String s : loreString) {
			lore.add(ChatUtils.chat(s));
		}
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.values());
		if (enchanted) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		item.setItemMeta(meta);

		return item;
	}


	public static void giveItem(Player player, ItemStack item) {
		if (player.getInventory().firstEmpty() != -1) {
			player.getInventory().addItem(item);
		} else {
			player.getWorld().dropItem(player.getLocation(), item);
		}
	}


	public static boolean itemLoreHasString(ItemStack item, String content) {
		if (item != null) {
			ItemMeta meta = item.getItemMeta();
			List<String> lore = meta.getLore();

			if (lore != null) {
				for (String lineLore : lore) {
					if (lineLore.toLowerCase().contains(content.toLowerCase())) {
						return true;
					}
				}
			}
		}

		return false;
	}


	public static String getItemLoreLineContaining(ItemStack item, String content) {
		if (item != null) {
			ItemMeta meta = item.getItemMeta();
			List<String> lore = meta.getLore();

			if (lore != null) {
				for (String lineLore : lore) {
					if (lineLore.toLowerCase().contains(content.toLowerCase())) {
						return lineLore;
					}
				}
			}
		}

		return "";
	}

	/// Obtengo un item al que le remuevo una linea del lore
	/// Give: item, string perteneciente a la linea eliminar
	/// Return: item sin la linea
	public static ItemStack removeStringFromItemLore(ItemStack itemStack, String content) {
		ItemMeta meta = itemStack.getItemMeta();
		List<String> lore = meta.getLore();

		if (lore == null) {
			lore = new ArrayList<String>();
		}

		String lineToRemove = null;
		for (String lineLore : lore) {
			if (lineLore.toLowerCase().contains(content.toLowerCase())) {
				lineToRemove = lineLore;
			}
		}

		if (lineToRemove != null) {
			lore.remove(lineToRemove);
		}

		meta.setLore(lore);
		itemStack.setItemMeta(meta);
		return itemStack;
	}


	public static ItemStack addStringToItemLore(ItemStack itemStack, String content) {
		ItemMeta meta = itemStack.getItemMeta();
		List<String> lore = meta.getLore();

		if (lore == null) {
			lore = new ArrayList<String>();
		}

		lore.add(ChatUtils.chat(content));
		meta.setLore(lore);
		itemStack.setItemMeta(meta);
		return itemStack;

	}
}
