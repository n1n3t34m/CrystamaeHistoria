package io.github.sefiraat.crystamaehistoria.listeners;

import io.github.sefiraat.crystamaehistoria.slimefun.items.tools.DisplacedVoid;
import io.github.sefiraat.crystamaehistoria.slimefun.CrystaStacks;
import io.github.thebusybiscuit.slimefun4.implementation.tasks.player.InfusedMagnetTask;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.entity.Player;

public class DisplacedVoidListener implements Listener {

    // https://github.com/Slimefun/Slimefun4/blob/master/src/main/java/io/github/thebusybiscuit/slimefun4/implementation/listeners/GadgetsListener.java
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onToggleSneak(PlayerToggleSneakEvent e) {
        if (e.isSneaking()) {
            Player p = e.getPlayer();

            if (SlimefunUtils.containsSimilarItem(p.getInventory(), CrystaStacks.DISPLACED_VOID, true)) {
                DisplacedVoid magnet = (DisplacedVoid) CrystaStacks.DISPLACED_VOID.getItem();

                if (magnet.canUse(p, true)) {
                    new InfusedMagnetTask(p, magnet.getRadius()).scheduleRepeating(0, 8);
                }
            }
        }
    }

}
