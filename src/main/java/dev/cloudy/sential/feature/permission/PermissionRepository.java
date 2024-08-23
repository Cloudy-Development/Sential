package dev.cloudy.sential.feature.permission;

import dev.cloudy.sential.Sential;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.*;

/**
 * This class represents players with specific permissions.
 * It attaches a list of permissions to a set of players.
 *
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 19:05
 */
public class PermissionRepository {

    private final Map<String, Set<String>> playerPermissions = new HashMap<>();
    private final Sential plugin = Sential.getInstance(); // Use the plugin instance directly

    /**
     * Adds a permission to a player and saves it.
     *
     * @param playerName the player to add the permission to
     * @param permission the permission to add
     */
    public void addPermission(String playerName, String permission) {
        playerPermissions.computeIfAbsent(playerName, k -> new HashSet<>()).add(permission);
        savePermissions();

        Player player = plugin.getServer().getPlayer(playerName);
        if (player != null) {
            attachPermission(player, permission);
        }
    }

    /**
     * Gets the permissions of a player.
     *
     * @param player the player to get the permissions of
     * @return the permissions of the player
     */
    public List<String> getPlayerPerms(Player player) {
        Set<String> permissions = playerPermissions.get(player.getName());
        return new ArrayList<>(permissions);
    }

    /**
     * Removes a permission from a player and saves it.
     *
     * @param playerName the player to remove the permission from
     * @param permission the permission to remove
     */
    public void removePermission(String playerName, String permission) {
        Set<String> permissions = playerPermissions.get(playerName);
        if (permissions != null) {
            permissions.remove(permission);
            if (permissions.isEmpty()) {
                playerPermissions.remove(playerName);
            }
            savePermissions();

            Player player = plugin.getServer().getPlayer(playerName);
            if (player != null) {
                detachPermission(player, permission);
            }
        }

        plugin.getConfig().set("permissions." + playerName, null);
        plugin.saveConfig();
    }

    /**
     * Checks if a player has a specific permission.
     *
     * @param playerName the player to check
     * @param permission the permission to check
     * @return true if the player has the permission, false otherwise
     */
    public boolean hasPermission(String playerName, String permission) {
        Set<String> permissions = playerPermissions.get(playerName);
        return permissions != null && permissions.contains(permission);
    }

    /**
     * Loads permissions from the config file.
     */
    public void loadPermissions() {
        FileConfiguration config = plugin.getConfig();
        playerPermissions.clear();

        if (!config.contains("permissions")) {
            return;
        }

        for (String player : config.getConfigurationSection("permissions").getKeys(false)) {
            List<String> permissions = config.getStringList("permissions." + player);
            playerPermissions.put(player, new HashSet<>(permissions));
        }

        for (Map.Entry<String, Set<String>> entry : playerPermissions.entrySet()) {
            Player player = plugin.getServer().getPlayer(entry.getKey());
            if (player != null) {
                for (String permission : entry.getValue()) {
                    attachPermission(player, permission);
                }
            }
        }
    }

    /**
     * Saves permissions to the config file.
     */
    private void savePermissions() {
        FileConfiguration config = plugin.getConfig();

        for (Map.Entry<String, Set<String>> entry : playerPermissions.entrySet()) {
            String player = entry.getKey();
            Set<String> permissions = entry.getValue();
            config.set("permissions." + player, new ArrayList<>(permissions));
        }

        plugin.saveConfig();
    }

    /**
     * Attaches a permission to a player.
     *
     * @param player the player to attach the permission to
     * @param permission the permission to attach
     */
    public void attachPermission(Player player, String permission) {
        PermissionAttachment attachment = player.addAttachment(plugin);
        attachment.setPermission(permission, true);
    }

    /**
     * Detaches a permission from a player.
     *
     * @param player the player to detach the permission from
     * @param permission the permission to detach
     */
    public void detachPermission(Player player, String permission) {
        PermissionAttachment attachment = player.addAttachment(plugin);
        attachment.setPermission(permission, false);
        player.removeAttachment(attachment);
    }

    /**
     * Attaches all permissions to a player.
     *
     * @param player the player to attach the permissions to
     */
    public void attachPermissions(Player player) {
        Set<String> permissions = playerPermissions.get(player.getName());
        if (permissions != null) {
            PermissionAttachment attachment = player.addAttachment(plugin);
            for (String permission : permissions) {
                attachment.setPermission(permission, true);
            }
        }
    }
}