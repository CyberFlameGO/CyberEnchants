package net.cyberflame.cyberenchants.entity;

import java.util.ArrayList;
import java.util.List;

import net.cyberflame.cyberenchants.Main;
import net.cyberflame.cyberenchants.utils.ChatUtils;
import net.cyberflame.cyberenchants.utils.ItemUtils;
import net.cyberflame.cyberenchants.utils.TextUtils;

public class Manager {

	// Variables
	private Main plugin;
	private List<CustomEnchant> listCustomEnchants;

	// Constructor
	public Manager(Main plugin) {
		this.plugin = plugin;
		this.listCustomEnchants = new ArrayList<CustomEnchant>();
	}

	public List<CustomEnchant> getListCustomEnchants() {
		return listCustomEnchants;
	}

	public CustomEnchant getCustomEnchant(String name) {
		for (CustomEnchant customEnchant : this.listCustomEnchants) {
			if (customEnchant.getName().toLowerCase().equals(name.toLowerCase())) {
				return customEnchant;
			}
		}
		return null;
	}

	public void setListCustomEnchants(List<CustomEnchant> listCustomEnchants) {
		this.listCustomEnchants = listCustomEnchants;
	}

	public void addCustomEnchant(CustomEnchant customEnchant) {
		this.listCustomEnchants.add(customEnchant);
	}

	public void restartCustomEnchantList() {
		this.listCustomEnchants = new ArrayList<CustomEnchant>();
	}
	
	//Create tasks
	
	//Create Custom Enchants
	public CustomEnchant createWaterBreathingBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.water-breathing.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.water-breathing.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.water-breathing.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}

		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.water-breathing.name")),
				customEnchantLore));
		
		return customEnchant;
	}

	public CustomEnchant createNightVisionBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.night-vision.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.night-vision.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.night-vision.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.night-vision.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createStrengthBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.strength.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.strength.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.strength.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.strength.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.strength.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createSaturationBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.saturation.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.saturation.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.saturation.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.saturation.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.saturation.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createFireResistanceBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.fire-resistance.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.fire-resistance.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.fire-resistance.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.fire-resistance.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createSpeedBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.speed.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.speed.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.speed.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.speed.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.speed.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createJellyLegsBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.jelly-legs.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.jelly-legs.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.jelly-legs.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.jelly-legs.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createGrindBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.grind.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.grind.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.grind.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.grind.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.grind.name")),
				customEnchantLore));
		return customEnchant;
	}

	public CustomEnchant createObsidianBreakerBook() {
		CustomEnchant customEnchant = new CustomEnchant();
		customEnchant.setName(TextUtils.removeColours(plugin.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")));
		customEnchant.setCost(plugin.getConfig().getInt("EnchantingMenu.Enchants.obsidian-breaker.cost"));
		customEnchant.setSlot(plugin.getConfig().getInt("EnchantingMenu.Enchants.obsidian-breaker.slot"));

		List<String> customEnchantLore = new ArrayList<String>();
		for (String lineLore : plugin.getConfig().getStringList("EnchantingMenu.Enchants.obsidian-breaker.lore")) {
			customEnchantLore.add(lineLore.replace("{remove-item}", "").replace("{cost}", Integer.toString(customEnchant.getCost())));
		}
		
		customEnchant.setCustomEnchantBook(ItemUtils.createItem(403, 1, true,
				ChatUtils.chat(plugin.getConfig().getString("EnchantingMenu.Enchants.obsidian-breaker.name")),
				customEnchantLore));
		return customEnchant;
	}

}
