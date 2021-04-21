package net.cyberflame.cyberenchants;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import net.cyberflame.cyberenchants.commands.CustomEnchantCommand;
import net.cyberflame.cyberenchants.commands.CustomEnchantCompleter;
import net.cyberflame.cyberenchants.entity.EnchantsGUI;
import net.cyberflame.cyberenchants.entity.Manager;
import net.cyberflame.cyberenchants.hook.FactionsHook;
import net.cyberflame.cyberenchants.hook.FactionsTypeEnum;
import net.cyberflame.cyberenchants.listeners.ArmorEquipListener;
import net.cyberflame.cyberenchants.listeners.GrindListener;
import net.cyberflame.cyberenchants.listeners.GuiClickListener;
import net.cyberflame.cyberenchants.listeners.InventoryClickListener;
import net.cyberflame.cyberenchants.listeners.JellyLegsListener;
import net.cyberflame.cyberenchants.listeners.ObbyBreakerListener;
import net.cyberflame.cyberenchants.listeners.PlayerJoinListener;
import net.cyberflame.cyberenchants.utils.armorequipevent.ArmorListener;

public class Main extends JavaPlugin {

	public Plugin factionsPlugin;
	public FactionsTypeEnum factionsType;

	@Override
	public void onEnable() {
		saveDefaultConfig();

		// Initialize
		FactionsHook.hook(this);

		Manager manager = new Manager(this);
		manager.addCustomEnchant(manager.createFireResistanceBook());
		manager.addCustomEnchant(manager.createSaturationBook());
		manager.addCustomEnchant(manager.createNightVisionBook());
		manager.addCustomEnchant(manager.createWaterBreathingBook());
		manager.addCustomEnchant(manager.createSpeedBook());
		manager.addCustomEnchant(manager.createStrengthBook());
		manager.addCustomEnchant(manager.createJellyLegsBook());
		manager.addCustomEnchant(manager.createGrindBook());
		manager.addCustomEnchant(manager.createObsidianBreakerBook());

		EnchantsGUI enchantsGUI = new EnchantsGUI(this, manager);

		// Commands
		new CustomEnchantCommand(this, manager, enchantsGUI);
		new CustomEnchantCompleter(this, manager);

		// Listeners
		new ArmorListener(this);
		new ArmorEquipListener(this, manager);
		new GrindListener(this, manager);
		new GuiClickListener(this, enchantsGUI, manager);
		new InventoryClickListener(this, manager);
		new JellyLegsListener(this, manager);
		new ObbyBreakerListener(this, manager);
		new PlayerJoinListener(this, manager);
	}

	@Override
	public void onDisable() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			player.removePotionEffect(PotionEffectType.SATURATION);
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			player.removePotionEffect(PotionEffectType.WATER_BREATHING);
			player.removePotionEffect(PotionEffectType.SPEED);
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
	}

}
