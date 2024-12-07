package io.github.sefiraat.crystamaehistoria.listeners;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MagicSummonListener implements Listener {

	// Despawn Magic Summons after reloading to prevent weird interactions
	@EventHandler
	public void onEntityAddToWorld(EntityAddToWorldEvent e) {
		Entity entity = e.getEntity();
		if (!entity.isValid()) return;

		CrystamaeHistoria.getSummonedEntityMap()
				.keySet()
				.stream()
				.filter(x -> x.mobUUID.equals(entity.getUniqueId()))
				.findFirst()
				.ifPresent(x -> {
					CrystamaeHistoria.getInstance().getLogger().info("Removing MagicSummon " + x.mobUUID);
					Bukkit.getScheduler().runTaskLater(CrystamaeHistoria.getInstance(), x::kill, 1);
				});
	}

}
