package net.cyberflame.cyberenchants.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ArmorUtils {


	public static List<ItemStack> getArmorEquiped (Player player) {
		List<ItemStack> armorList = new ArrayList<ItemStack>();
		armorList.add(player.getInventory().getHelmet());
		armorList.add(player.getInventory().getChestplate());
		armorList.add(player.getInventory().getLeggings());
		armorList.add(player.getInventory().getBoots());
		
		return armorList;
	}


	public static ItemStack getHelmetEquiped(Player player) {
		return player.getInventory().getHelmet();
	}


	public static ItemStack getChestplateEquiped(Player player) {
		return player.getInventory().getChestplate();
	}


	public static ItemStack getLeggingsEquiped(Player player) {
		return player.getInventory().getLeggings();
	}


	public static ItemStack getBootsEquiped(Player player) {
		return player.getInventory().getBoots();
	}
	

	@SuppressWarnings("deprecation")
	public static boolean isHelmet(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 298 || armorPiece.getTypeId() == 302 || armorPiece.getTypeId() == 306
				|| armorPiece.getTypeId() == 310 || armorPiece.getTypeId() == 314) {
			return true;
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	public static boolean isChestplate(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 299 || armorPiece.getTypeId() == 303 || armorPiece.getTypeId() == 307
				|| armorPiece.getTypeId() == 311 || armorPiece.getTypeId() == 315) {
			return true;
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	public static boolean isLeggings(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 300 || armorPiece.getTypeId() == 304 || armorPiece.getTypeId() == 308
				|| armorPiece.getTypeId() == 312 || armorPiece.getTypeId() == 316) {
			return true;
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	public static boolean isBoots(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 301 || armorPiece.getTypeId() == 305 || armorPiece.getTypeId() == 309
				|| armorPiece.getTypeId() == 313 || armorPiece.getTypeId() == 317) {
			return true;
		}
		return false;
	}
	

	@SuppressWarnings("deprecation")
	public static boolean isSword(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 267 || armorPiece.getTypeId() == 268 || armorPiece.getTypeId() == 272
				|| armorPiece.getTypeId() == 276 || armorPiece.getTypeId() == 283) {
			return true;
		}
		return false;
	}


	@SuppressWarnings("deprecation")
	public static boolean isPickaxe(ItemStack armorPiece) {
		if (armorPiece == null)
			return false;
		 
		if (armorPiece.getTypeId() == 257 || armorPiece.getTypeId() == 270 || armorPiece.getTypeId() == 274
				|| armorPiece.getTypeId() == 278 || armorPiece.getTypeId() == 285) {
			return true;
		}
		return false;
	}
}
