package dev.cloudy.sential.feature.godmode.listener;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.feature.godmode.GodModeRepository;
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
    private final GodModeRepository godModeRepository = Sential.getInstance().getGodModeRepository();

    @EventHandler
    private void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeRepository.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeRepository.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void onEntityDamageByBlock(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModeRepository.isGodModeEnabled(player)) {
                event.setCancelled(true);
            }
        }
    }
}
