package dev.cloudy.sential.feature.chat.format.listener;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.feature.chat.format.ChatFormat;
import dev.cloudy.sential.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:33
 */
public class ChatListener implements Listener {

    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (Sential.getInstance().getConfig().getBoolean("chat.format.enabled")) {
            event.setFormat(CC.translate(ChatFormat.getFormat(player, event.getMessage())));
        }

        if (Sential.getInstance().getChatRepository().isChatMuted()) {
            if (player.hasPermission("sential.chat.mute.bypass")) {
                return;
            }

            player.sendMessage(CC.translate("&cThe chat is currently muted."));
            event.setCancelled(true);
        }
    }
}
