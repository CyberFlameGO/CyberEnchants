package net.cyberflame.cyberenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.hook.FactionsTypeEnum;
import net.cyberflame.cyberenchants.utils.ArmorUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class ObbyBreakerListener implements Listener {

	// Variables
	private Main main;
	@SuppressWarnings("unused")
	private Manager manager;

	// Constructor
	public ObbyBreakerListener(Main main, Manager manager) {
		this.main = main;
		this.manager = manager;

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	// Events
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (ArmorUtils.isPickaxe(event.getItem())) {
			if (event.getAction() == Action.LEFT_CLICK_BLOCK
					&& event.getClickedBlock().getType() == Material.OBSIDIAN) {
				if (ItemUtils.itemLoreHasString(event.getItem(), TextUtils.removeColours(main.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.display-Name")))) {

					if (main.factionsType == FactionsTypeEnum.FactionsUUID) {

						FPlayer fPlayer = FPlayers.getInstance().getByPlayer(event.getPlayer());
						Faction playerFaction = fPlayer.getFaction();
						FLocation blockLocation = new FLocation(event.getClickedBlock());
						Faction landFactionOwner = Board.getInstance().getFactionAt(blockLocation);

						@SuppressWarnings("deprecation")
						boolean hasFaction = landFactionOwner != null && !landFactionOwner.isNone();
						if (landFactionOwner.getTag().equals(playerFaction.getTag()) || hasFaction == false) {
							instaBreakBlock(event.getClickedBlock());
						}

					} else {
						instaBreakBlock(event.getClickedBlock());
					}

				}
			}
		}
	}

	public void instaBreakBlock(Block block) {
		Location dropLocation = new Location(block.getWorld(), block.getX() + 0.5, block.getY() + 0.5,
				block.getZ() + 0.5);
		block.getWorld().dropItem(dropLocation, new ItemStack(Material.OBSIDIAN));
		block.setType(Material.AIR);
	}
}
