package net.cyberflame.cyberenchants.entity;

import org.bukkit.inventory.ItemStack;

public class CustomEnchant {

	//Variables
	private String name;
	private ItemStack customEnchantBook;
	private int cost;
	private int slot;
	
	//Constructor
	public CustomEnchant(String name, ItemStack customEnchantBook) {
		this.name = name;
		this.customEnchantBook = customEnchantBook;
	}

	public CustomEnchant() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemStack getCustomEnchantBook() {
		return customEnchantBook;
	}

	public void setCustomEnchantBook(ItemStack customEnchantBook) {
		this.customEnchantBook = customEnchantBook;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	
}
