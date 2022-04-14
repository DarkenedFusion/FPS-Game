package io.github.darkenedfusion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ItemLibrary {
	
	public ItemStack pistolItem() {
		
		ItemStack pistol = new ItemStack(Material.FLINT);
		ItemMeta meta = pistol.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Pistol");
		meta.setUnbreakable(true);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "A basic gun");
		meta.setLore(lore);
		pistol.setItemMeta(meta);
		
		return pistol;
	}
	
public ItemStack autoRifleItem() {
		
		ItemStack autoRifle = new ItemStack(Material.SLIME_BALL);
		ItemMeta meta = autoRifle.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Automatic Rifle");
		meta.setUnbreakable(true);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "An intermidiate gun");
		meta.setLore(lore);
		autoRifle.setItemMeta(meta);
		
		return autoRifle;
	}

}
