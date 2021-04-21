package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class JellyLegsListener implements Listener {

	// Variables
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public JellyLegsListener(Main main, Manager manager) {
		super(); 
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	//Events
	@EventHandler
	public void entityDamageEvent(EntityDamageEvent event) {
		//If the entity isn't a player
		if (!(event.getEntity() instanceof Player))
			return;
		//If damage is caused by a fall
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL)
			return;
		if (ItemUtils.itemLoreHasString(ArmorUtils.getBootsEquiped((Player) event.getEntity()), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.display-Name")))) {
			event.setCancelled(true);
		}
	}
}
