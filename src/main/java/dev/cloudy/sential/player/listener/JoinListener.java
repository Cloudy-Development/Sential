package dev.cloudy.sential.player.listener;

import dev.cloudy.sential.Sential;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 19:36
 */
public class JoinListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Sential.getInstance().getPermissionRepository().attachPermissions(player);
    }
}
