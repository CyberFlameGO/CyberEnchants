package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.armorequipevent.ArmorEquipEvent;

public class ArmorEquipListener implements Listener {

	// Variables
	@SuppressWarnings("unused")
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public ArmorEquipListener(Main main, Manager manager) {
		super();
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onArmorEquip(ArmorEquipEvent event) {
		ItemStack newArmorPiece = event.getNewArmorPiece();
		ItemStack oldArmorPiece = event.getOldArmorPiece();

		if (removingArmor(newArmorPiece, oldArmorPiece)) {
			checkIfApplyEffect(oldArmorPiece, false, event.getPlayer());
		} else {
			checkIfApplyEffect(newArmorPiece, true, event.getPlayer());
		}
		
	}

	public boolean removingArmor(ItemStack newArmorPiece, ItemStack oldArmorPiece) {

		if (ArmorUtils.isHelmet(oldArmorPiece) || ArmorUtils.isChestplate(oldArmorPiece) || ArmorUtils.isLeggings(oldArmorPiece) || ArmorUtils.isBoots(oldArmorPiece)) {
			if (newArmorPiece == null  || newArmorPiece.getType().equals(Material.AIR)) {
				return true;
			}
		}
		return false;

	}

	public void checkIfApplyEffect(ItemStack armorPiece, boolean applyEffect, Player player) {
		if (ArmorUtils.isHelmet(armorPiece)) {
			if (ItemUtils.itemLoreHasString(armorPiece, "Water Breathing")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0, true, true), player);
			}
			if (ItemUtils.itemLoreHasString(armorPiece, "Night Vision")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, true), player);
			}
			return;
		} else if (ArmorUtils.isChestplate(armorPiece)) {
			if (ItemUtils.itemLoreHasString(armorPiece, "Strength")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, true, true), player);
			}
			if (ItemUtils.itemLoreHasString(armorPiece, "Saturation")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0, true, true), player);
			}
			return;
		} else if (ArmorUtils.isLeggings(armorPiece)) {
			if (ItemUtils.itemLoreHasString(armorPiece, "Fire Resistance")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, true, true), player);
			}
		} else if (ArmorUtils.isBoots(armorPiece)) {
			if (ItemUtils.itemLoreHasString(armorPiece, "Speed")) {
				applyPotionEffect(applyEffect, new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, true), player);
			}
			
		}
	}
	
	public void applyPotionEffect (boolean applyEffect, PotionEffect potionEffect, Player player) {
		if (applyEffect) {
			player.addPotionEffect(potionEffect);
		} else {
			player.removePotionEffect(potionEffect.getType());
		}
	}

}
