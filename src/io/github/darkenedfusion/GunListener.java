package io.github.darkenedfusion;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class GunListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPistol(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		Action action = event.getAction();
		
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
				if(player.getInventory().getItemInMainHand().getType().equals(Material.FLINT)) {
					if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Pistol")){
						 
						double max = 0.1;
						double min = -0.1;
						double accuracy = ((Math.random() * (max - min)) + min);
						
						if(!player.isOnGround()) {
							double randDouble = Math.random();
							if(randDouble <= 50) {
								accuracy += 1;
							} else if(randDouble <= 100) {
								accuracy -= 1;
							}
							
						}
						Arrow arrow = event.getPlayer().launchProjectile(Arrow.class);
						Vector vector = event.getPlayer().getLocation().getDirection();
						vector.add(new Vector(Math.random() * accuracy - accuracy, Math.random() * accuracy - accuracy, Math.random() * accuracy - accuracy));
						arrow.setVelocity(vector);
						arrow.setVelocity(arrow.getVelocity().multiply(1));
						
						
					}
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onAutoRifle(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		Action action = event.getAction();
		
		if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
				if(player.getInventory().getItemInMainHand().getType().equals(Material.SLIME_BALL)) {
					if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Automatic Rifle")){
						 
						double max = 0.16;
						double min = -0.16;
						double accuracy = ((Math.random() * (max - min)) + min);
						
						if(!player.isOnGround()) {
							double randDouble = Math.random();
							if(randDouble <= 50) {
								accuracy += 1;
							} else if(randDouble <= 100) {
								accuracy -= 1;
							}
							
						}
						Arrow arrow = event.getPlayer().launchProjectile(Arrow.class);
						Vector vector = event.getPlayer().getLocation().getDirection();
						vector.add(new Vector(Math.random() * accuracy - accuracy, Math.random() * accuracy - accuracy, Math.random() * accuracy - accuracy));
						arrow.setVelocity(vector);
						arrow.setVelocity(arrow.getVelocity().multiply(2));
						
						
					}
			}
		}
	}
	
	
	@EventHandler
	public void gunDamage(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Arrow) {
			Arrow a = (Arrow) event.getDamager();
			if(a.getShooter() instanceof Player) {
				Player player = (Player) a.getShooter();
				if(player.getInventory().getItemInMainHand().getType().equals(Material.FLINT)) {
					if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Pistol")){
						event.setDamage(5);
						((Player) a.getShooter()).sendMessage("You dealt a total of " + event.getDamage() + "");
					}
				}
				if(player.getInventory().getItemInMainHand().getType().equals(Material.SLIME_BALL)) {
					if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Automatic Rifle")){
						event.setDamage(3);
						((Player) a.getShooter()).sendMessage("You dealt a total of " + event.getDamage() + "");
					}
				}
			}
			
			
		} else {
			return;
		}
	}
	
	
	
	
	

}
