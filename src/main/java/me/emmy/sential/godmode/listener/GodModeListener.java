package me.emmy.sential.godmode.listener;

import me.emmy.sential.Sential;
import me.emmy.sential.godmode.GodModeRepository;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * @author Emmy
 * @project Sential
 * @date 29/07/2024 - 19:43
 */
public class GodModeListener implements Listener {
    private final GodModeRepository godModeMemory = Sential.getInstance().getGodModeRepository();

    @EventHandler
    private void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeMemory.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeMemory.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void onEntityDamageByBlock(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeMemory.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }
}
