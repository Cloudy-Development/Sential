package dev.cloudy.sential.feature.godmode;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * GodModeRepository handles the god-mode feature.
 * It contains a set of players whose can be added through commands.
 *
 * @author Emmy
 * @project Sential
 * @date 29/07/2024 - 19:42
 */
public class GodModeRepository {
    private final Set<Player> godModePlayers = new HashSet<>();

    /**
     * Set a player to godmode
     *
     * @param player The player to set to godmode
     */
    public void enableGodMode(Player player) {
        player.setAllowFlight(true);
        player.setFlying(true);

        godModePlayers.add(player);
    }

    /**
     * Remove a player from godmode
     *
     * @param player The player to remove from godmode
     */
    public void disableGodMode(Player player) {
        player.setAllowFlight(false);
        player.setFlying(false);

        godModePlayers.remove(player);
    }

    /**
     * Check if a player is in godmode
     *
     * @param player The player to check
     * @return If the player is in godmode
     */
    public boolean isGodModeEnabled(Player player) {
        return godModePlayers.contains(player);
    }
}
