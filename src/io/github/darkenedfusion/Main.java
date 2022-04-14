package io.github.darkenedfusion;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		this.getCommand("grant").setExecutor(new GrantCommand());
		
		
		this.getServer().getPluginManager().registerEvents(new GunListener(), this);
		this.getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public static Main getInstance() {
        return instance;
    }
	
	
	//Garbage Collector
	@EventHandler
	public void onLand(ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow arrow && event.getHitBlock() != null) {
		    new BukkitRunnable() {
		    	double t = 0;
				@Override
				public void run() {
					t++;
					
					if(t >= 5) {
						event.getEntity().remove();
					}
				}
		    	
		    }.runTaskTimer(this, 0, 20);
		} else {
			return;
		}
		}
	
	
	
}
