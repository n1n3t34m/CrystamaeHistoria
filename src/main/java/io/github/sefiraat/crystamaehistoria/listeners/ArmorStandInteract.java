package io.github.sefiraat.crystamaehistoria.listeners;

import io.github.sefiraat.crystamaehistoria.slimefun.CrystaStacks;
import io.github.sefiraat.crystamaehistoria.slimefun.items.artistic.ImbuedStand;
import io.github.sefiraat.crystamaehistoria.utils.ArmourStandUtils;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ArmorStandInteract implements Listener {

    @EventHandler
    public void onArmorStandManipulate(PlayerArmorStandManipulateEvent e) {
        if (ArmourStandUtils.isDisplayStand(e.getRightClicked())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onArmorDispense(BlockDispenseArmorEvent e) {
        if (e.getTargetEntity() instanceof ArmorStand && ArmourStandUtils.isDisplayStand((ArmorStand) e.getTargetEntity())) {
            e.setCancelled(true);
        }
    }

    // Drop Imbued Armor Stand on break
    @EventHandler
    public void onArmorStandBreak(EntityDeathEvent e) {
        final Entity entity = e.getEntity();
        if (entity instanceof ArmorStand armorStand && PersistentDataAPI.getBoolean(armorStand, ImbuedStand.KEY)) {
            e.getDrops().replaceAll(x -> x.getType() == Material.ARMOR_STAND ? CrystaStacks.IMBUED_STAND : x);
        }
    }
}
