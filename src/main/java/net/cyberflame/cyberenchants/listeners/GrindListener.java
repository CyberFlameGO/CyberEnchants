package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class GrindListener implements Listener {

	// Variables
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public GrindListener(Main main, Manager manager) {
		super();
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	//Events
	@EventHandler
	public void entityDeathEvent(EntityDeathEvent event) {
		if (event.getEntity() != null && event.getEntity().getKiller() != null) {
			Player killer = event.getEntity().getKiller();
			ItemStack item = killer.getItemInHand();

			if (ArmorUtils.isSword(item) && ItemUtils.itemLoreHasString(item, TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.grind.display-Name")))) {
				event.setDroppedExp(event.getDroppedExp()*2);
			}
		}
	}
}
