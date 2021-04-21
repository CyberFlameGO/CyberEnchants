package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class PlayerJoinListener implements Listener {

	// Variables
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public PlayerJoinListener(Main main, Manager manager) {
		super();
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		if (ArmorUtils.getHelmetEquiped(player) != null) {
			if (ItemUtils.itemLoreHasString(ArmorUtils.getHelmetEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.water-breathing.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 0, true, true), player);
			}
			if (ItemUtils.itemLoreHasString(ArmorUtils.getHelmetEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.night-vision.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, true), player);
			}
		}
		
		if (ArmorUtils.getChestplateEquiped(player) != null) {
			if (ItemUtils.itemLoreHasString(ArmorUtils.getChestplateEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.strength.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, true, true), player);
			}
			if (ItemUtils.itemLoreHasString(ArmorUtils.getChestplateEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.saturation.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 0, true, true), player);
			}
		}
		
		if (ArmorUtils.getLeggingsEquiped(player) != null) {
			if (ItemUtils.itemLoreHasString(ArmorUtils.getLeggingsEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0, true, true), player);
			}
		}
		
		if (ArmorUtils.getBootsEquiped(player) != null) {
			if (ItemUtils.itemLoreHasString(ArmorUtils.getBootsEquiped(player), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.speed.display-Name")))) {
				applyPotionEffect(true, new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, true), player);
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
