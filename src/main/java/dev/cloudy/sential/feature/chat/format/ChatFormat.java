package dev.cloudy.sential.feature.chat.format;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.util.CC;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

/**
 * Chat format utility class.
 * This class is used to get the chat format from the config
 *
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:33
 */
@UtilityClass
public class ChatFormat {

    /**
     * Get the chat format from the config.
     * Replace Player object and the String which represents the event message
     *
     * @param player the player
     * @return the chat format
     */
    public String getFormat(Player player, String message) {
        String opColor = Sential.getInstance().getConfig().getString("chat.format.op-prefix");
        String isOp = player.isOp() ? opColor : "";
        return Sential.getInstance().getConfig().getString("chat.format.format")
                .replace("{player}", isOp + player.getName())
                .replace("{message}", message);
    }
}
