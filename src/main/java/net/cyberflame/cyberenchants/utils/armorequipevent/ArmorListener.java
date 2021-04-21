package net.cyberflame.cyberenchants.utils.armorequipevent;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

import net.cyberflame.cyberenchants.Main;

public class ArmorListener implements Listener {
	private final List<String> blockedMaterials;

	private Main main;
	
	public ArmorListener(Main main) {
		this.main = main;
		this.blockedMaterials = getBlocks();

		Bukkit.getPluginManager().registerEvents(this, main);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public final void onInventoryClick(InventoryClickEvent event) {
		boolean shift = false, numberkey = false;
		Player player = (Player) event.getWhoClicked();
		if (event.isCancelled())
			return;
		if (event.getClick().equals(ClickType.SHIFT_LEFT) || event.getClick().equals(ClickType.SHIFT_RIGHT))
			shift = true;
		if (event.getClick().equals(ClickType.NUMBER_KEY))
			numberkey = true;
		if ((event.getSlotType() != InventoryType.SlotType.ARMOR || event.getSlotType() != InventoryType.SlotType.QUICKBAR)
				&& !event.getInventory().getType().equals(InventoryType.CRAFTING)
				&& !event.getInventory().getType().equals(InventoryType.PLAYER))
			return;
		if (!(event.getWhoClicked() instanceof Player))
			return;
		if (event.getCurrentItem() == null)
			return;
		ArmorType newArmorType = ArmorType.matchType(shift ? event.getCurrentItem() : event.getCursor());
		if (!shift && newArmorType != null && event.getRawSlot() != newArmorType.getSlot())
			return;
		if (event.getInventory().getType() == InventoryType.CRAFTING)
			if (event.getRawSlot() >= 0 && event.getRawSlot() <= 4)
				return;
		if (shift) {
			newArmorType = ArmorType.matchType(event.getCurrentItem());
			if (newArmorType != null) {
				boolean equipping = true;
				if (event.getRawSlot() == newArmorType.getSlot())
					equipping = false;
				if ((newArmorType.equals(ArmorType.HELMET)
						&& (equipping ? (event.getWhoClicked().getInventory().getHelmet() == null)
								: (event.getWhoClicked().getInventory().getHelmet() != null)))
						|| (newArmorType.equals(ArmorType.CHESTPLATE)
								&& (equipping ? (event.getWhoClicked().getInventory().getChestplate() == null)
										: (event.getWhoClicked().getInventory().getChestplate() != null)))
						|| (newArmorType.equals(ArmorType.LEGGINGS)
								&& (equipping ? (event.getWhoClicked().getInventory().getLeggings() == null)
										: (event.getWhoClicked().getInventory().getLeggings() != null)))
						|| (newArmorType.equals(ArmorType.BOOTS)
								&& (equipping ? (event.getWhoClicked().getInventory().getBoots() == null)
										: (event.getWhoClicked().getInventory().getBoots() != null)))) {
					ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player,
							ArmorEquipEvent.EquipMethod.SHIFT_CLICK, newArmorType,
							equipping ? null : event.getCurrentItem(), equipping ? event.getCurrentItem() : null);
					Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
					if (armorEquipEvent.isCancelled())
						event.setCancelled(true);
				}
			}
		} else {
			ItemStack newArmorPiece = event.getCursor();
			if (newArmorPiece == null)
				newArmorPiece = new ItemStack(Material.AIR);
			ItemStack oldArmorPiece = event.getCurrentItem();
			if (oldArmorPiece == null)
				oldArmorPiece = new ItemStack(Material.AIR);
			if (numberkey) {
				if (event.getInventory().getType().equals(InventoryType.PLAYER)) {
					ItemStack hotbarItem = event.getInventory().getItem(event.getHotbarButton());
					if (hotbarItem != null) {
						newArmorType = ArmorType.matchType(hotbarItem);
						newArmorPiece = hotbarItem;
						oldArmorPiece = event.getInventory().getItem(event.getSlot());
					} else {
						newArmorType = ArmorType
								.matchType((event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)
										? event.getCurrentItem()
										: event.getCursor());
					}
				}
			} else {
				newArmorType = ArmorType
						.matchType((event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR)
								? event.getCurrentItem()
								: event.getCursor());
			}
			if (newArmorType != null && event.getRawSlot() == newArmorType.getSlot()) {
				ArmorEquipEvent.EquipMethod method = ArmorEquipEvent.EquipMethod.DRAG;
				if (event.getAction().equals(InventoryAction.HOTBAR_SWAP) || numberkey)
					method = ArmorEquipEvent.EquipMethod.HOTBAR_SWAP;
				ItemStack It = newArmorPiece.clone();
				ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player, method, newArmorType, oldArmorPiece,
						newArmorPiece);
				Bukkit.getScheduler().scheduleSyncDelayedTask(main, () -> {
					ItemStack I = event.getWhoClicked().getInventory().getItem(event.getSlot());
					if (event.getInventory().getType().equals(InventoryType.PLAYER)) {
						if (event.getSlot() == ArmorType.HELMET.getSlot())
							I = event.getWhoClicked().getEquipment().getHelmet();
						if (event.getSlot() == ArmorType.CHESTPLATE.getSlot())
							I = event.getWhoClicked().getEquipment().getChestplate();
						if (event.getSlot() == ArmorType.LEGGINGS.getSlot())
							I = event.getWhoClicked().getEquipment().getLeggings();
						if (event.getSlot() == ArmorType.BOOTS.getSlot())
							I = event.getWhoClicked().getEquipment().getBoots();
					}
					if (I == null) {
						if (event.getInventory().getType().equals(InventoryType.CRAFTING))
							I = new ItemStack(Material.AIR, 0);
						if (event.getInventory().getType().equals(InventoryType.PLAYER))
							I = new ItemStack(Material.AIR, 1);
					}
					if (I.isSimilar(It) || (I.getType() == Material.AIR && It.getType() == Material.AIR)) {
						Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
						if (armorEquipEvent.isCancelled())
							event.setCancelled(true);
					}
				});
			} else if (event.getHotbarButton() >= 0) {
				newArmorPiece = event.getWhoClicked().getInventory().getItem(event.getHotbarButton());
				if (oldArmorPiece != null)
					if (ArmorType.matchType(oldArmorPiece) != null || oldArmorPiece.getType() == Material.AIR)
						if (ArmorType.matchType(newArmorPiece) != null || newArmorPiece == null) {
							if (ArmorType.matchType(oldArmorPiece) != null)
								if (event.getRawSlot() != ArmorType.matchType(oldArmorPiece).getSlot())
									return;
							if (ArmorType.matchType(newArmorPiece) != null)
								if (event.getRawSlot() != ArmorType.matchType(newArmorPiece).getSlot())
									return;
							ArmorEquipEvent.EquipMethod method = ArmorEquipEvent.EquipMethod.DRAG;
							if (event.getAction().equals(InventoryAction.HOTBAR_SWAP) || numberkey)
								method = ArmorEquipEvent.EquipMethod.HOTBAR_SWAP;
							ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player, method, newArmorType,
									oldArmorPiece, newArmorPiece);
							Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
							if (armorEquipEvent.isCancelled())
								event.setCancelled(true);
						}
			}
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void playerInteractEvent(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.PHYSICAL))
			return;
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Player player = event.getPlayer();
			if (event.getClickedBlock() != null && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				Material mat = event.getClickedBlock().getType();
				for (String s : this.blockedMaterials) {
					if (mat.name().toLowerCase().contains(s.toLowerCase()))
						return;
				}
			}
			ArmorType newArmorType = ArmorType.matchType(event.getItem());
			if (newArmorType != null)
				if ((newArmorType.equals(ArmorType.HELMET) && event.getPlayer().getInventory().getHelmet() == null)
						|| (newArmorType.equals(ArmorType.CHESTPLATE)
								&& event.getPlayer().getInventory().getChestplate() == null)
						|| (newArmorType.equals(ArmorType.LEGGINGS)
								&& event.getPlayer().getInventory().getLeggings() == null)
						|| (newArmorType.equals(ArmorType.BOOTS) && event.getPlayer().getInventory().getBoots() == null)) {
					ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(event.getPlayer(),
							ArmorEquipEvent.EquipMethod.HOTBAR, ArmorType.matchType(event.getItem()), null, event.getItem());
					Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
					if (armorEquipEvent.isCancelled()) {
						event.setCancelled(true);
						player.updateInventory();
					}
				}
		}
	}

	@EventHandler
	public void dispenserFireEvent(BlockDispenseEvent event) {
		ArmorType type = ArmorType.matchType(event.getItem());
		if (ArmorType.matchType(event.getItem()) != null) {
			Location loc = event.getBlock().getLocation();
			for (Player p : loc.getWorld().getPlayers()) {
				if (loc.getBlockY() - p.getLocation().getBlockY() >= -1
						&& loc.getBlockY() - p.getLocation().getBlockY() <= 1)
					if ((p.getInventory().getHelmet() == null && type.equals(ArmorType.HELMET))
							|| (p.getInventory().getChestplate() == null && type.equals(ArmorType.CHESTPLATE))
							|| (p.getInventory().getLeggings() == null && type.equals(ArmorType.LEGGINGS))
							|| (p.getInventory().getBoots() == null && type.equals(ArmorType.BOOTS)))
						if (event.getBlock().getState() instanceof Dispenser) {
							Dispenser dispenser = (Dispenser) event.getBlock().getState();
							Dispenser dis = (Dispenser) dispenser.getData();
							BlockFace directionFacing = ((org.bukkit.material.Dispenser) dis).getFacing();
							if ((directionFacing == BlockFace.EAST && p.getLocation().getBlockX() != loc.getBlockX()
									&& p.getLocation().getX() <= loc.getX() + 2.3D
									&& p.getLocation().getX() >= loc.getX())
									|| (directionFacing == BlockFace.WEST && p.getLocation().getX() >= loc.getX() - 1.3D
											&& p.getLocation().getX() <= loc.getX())
									|| (directionFacing == BlockFace.SOUTH
											&& p.getLocation().getBlockZ() != loc.getBlockZ()
											&& p.getLocation().getZ() <= loc.getZ() + 2.3D
											&& p.getLocation().getZ() >= loc.getZ())
									|| (directionFacing == BlockFace.NORTH
											&& p.getLocation().getZ() >= loc.getZ() - 1.3D
											&& p.getLocation().getZ() <= loc.getZ())) {
								ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p,
										ArmorEquipEvent.EquipMethod.DISPENSER, ArmorType.matchType(event.getItem()), null,
										event.getItem());
								Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
								if (armorEquipEvent.isCancelled())
									event.setCancelled(true);
								return;
							}
						}
			}
		}
	}

	@EventHandler
	public void itemBreakEvent(PlayerItemBreakEvent event) {
		ArmorType type = ArmorType.matchType(event.getBrokenItem());
		if (type != null) {
			Player p = event.getPlayer();
			ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p, ArmorEquipEvent.EquipMethod.BROKE, type,
					event.getBrokenItem(), null);
			Bukkit.getServer().getPluginManager().callEvent((Event) armorEquipEvent);
			if (armorEquipEvent.isCancelled()) {
				ItemStack i = event.getBrokenItem().clone();
				i.setAmount(1);
				i.setDurability((short) (i.getDurability() - 1));
				if (type.equals(ArmorType.HELMET)) {
					p.getInventory().setHelmet(i);
				} else if (type.equals(ArmorType.CHESTPLATE)) {
					p.getInventory().setChestplate(i);
				} else if (type.equals(ArmorType.LEGGINGS)) {
					p.getInventory().setLeggings(i);
				} else if (type.equals(ArmorType.BOOTS)) {
					p.getInventory().setBoots(i);
				}
			}
		}
	}

	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent event) {
		Player p = event.getEntity();
		for (ItemStack i : p.getInventory().getArmorContents()) {
			if (i != null && !i.getType().equals(Material.AIR))
				Bukkit.getServer().getPluginManager().callEvent((Event) new ArmorEquipEvent(p,
						ArmorEquipEvent.EquipMethod.DEATH, ArmorType.matchType(i), i, null));
		}
	}

	private List<String> getBlocks() {
		List<String> blocks = new ArrayList<>();
		blocks.add("FURNACE");
		blocks.add("CHEST");
		blocks.add("TRAPPED_CHEST");
		blocks.add("BEACON");
		blocks.add("DISPENSER");
		blocks.add("DROPPER");
		blocks.add("HOPPER");
		blocks.add("WORKBENCH");
		blocks.add("ENCHANTMENT_TABLE");
		blocks.add("ENDER_CHEST");
		blocks.add("ANVIL");
		blocks.add("BED_BLOCK");
		blocks.add("FENCE_GATE");
		blocks.add("SPRUCE_FENCE_GATE");
		blocks.add("BIRCH_FENCE_GATE");
		blocks.add("ACACIA_FENCE_GATE");
		blocks.add("JUNGLE_FENCE_GATE");
		blocks.add("DARK_OAK_FENCE_GATE");
		blocks.add("IRON_DOOR_BLOCK");
		blocks.add("WOODEN_DOOR");
		blocks.add("SPRUCE_DOOR");
		blocks.add("BIRCH_DOOR");
		blocks.add("JUNGLE_DOOR");
		blocks.add("ACACIA_DOOR");
		blocks.add("DARK_OAK_DOOR");
		blocks.add("WOOD_BUTTON");
		blocks.add("STONE_BUTTON");
		blocks.add("TRAP_DOOR");
		blocks.add("IRON_TRAPDOOR");
		blocks.add("DIODE_BLOCK_OFF");
		blocks.add("DIODE_BLOCK_ON");
		blocks.add("REDSTONE_COMPARATOR_OFF");
		blocks.add("REDSTONE_COMPARATOR_ON");
		blocks.add("FENCE");
		blocks.add("SPRUCE_FENCE");
		blocks.add("BIRCH_FENCE");
		blocks.add("JUNGLE_FENCE");
		blocks.add("DARK_OAK_FENCE");
		blocks.add("ACACIA_FENCE");
		blocks.add("NETHER_FENCE");
		blocks.add("BREWING_STAND");
		blocks.add("CAULDRON");
		blocks.add("SIGN_POST");
		blocks.add("WALL_SIGN");
		blocks.add("SIGN");
		blocks.add("DRAGON_EGG");
		blocks.add("LEVER");
		blocks.add("SHULKER_BOX");
		return blocks;
	}
}
