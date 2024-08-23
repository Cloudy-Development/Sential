package dev.cloudy.sential.feature.chat.format;

import dev.cloudy.sential.Sential;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:33
 */
@UtilityClass
public class ChatFormat {

    /**
     * Get the chat format.
     *
     * @param player the player
     * @return the chat format
     */
    public String getFormat(Player player, String message) {
        return Sential.getInstance().getConfig().getString("chat.format.format").replace("{player}", player.getName()).replace("{message}", message);
    }
}
