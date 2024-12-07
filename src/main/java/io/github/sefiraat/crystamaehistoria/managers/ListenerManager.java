package io.github.sefiraat.crystamaehistoria.managers;

import io.github.sefiraat.crystamaehistoria.CrystamaeHistoria;
import io.github.sefiraat.crystamaehistoria.listeners.*;
import org.bukkit.event.Listener;

public class ListenerManager {

    public ListenerManager() {
        addListener(new ArmorStandInteract());
        addListener(new SpellCastListener());
        addListener(new SpellEffectListener());
        addListener(new CrystalBreakListener());
        addListener(new BlockRemovalListener());
        addListener(new MaintenanceListener());
        addListener(new RefractingLensListener());
        addListener(new ThaumaturgicSaltsListener());
        addListener(new CrystaDowngradeListener());
        addListener(new NetherDrainingListener());
        addListener(new SatchelListener());
        addListener(new EndermanInhibitorListener());
        addListener(new MobCandleListener());
        addListener(new DisplayItemListener());
        addListener(new PoseChangerListener());
        addListener(new PhilosophersSprayListener());
        addListener(new MiscListener());

        addListener(new DisplacedVoidListener());
        addListener(new MagicSummonListener());
    }

    private void addListener(Listener listener) {
        CrystamaeHistoria.getPluginManager().registerEvents(listener, CrystamaeHistoria.getInstance());
    }

}
