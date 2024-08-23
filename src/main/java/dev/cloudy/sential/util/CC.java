package dev.cloudy.sential.util;

import lombok.experimental.UtilityClass;
import dev.cloudy.sential.Sential;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

/**
 * @author Emmy
 * @project Sential
 * @date 29/07/2024 - 19:46
 */
@UtilityClass
public class CC {

    /**
     * Translate a string with color codes
     *
     * @param text The text to translate
     * @return The translated text
     */
    public String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Send a message to the console when the plugin is enabled
     */
    public void sendEnableMessage() {
        List<String> messages = Arrays.asList(
                "",
                "&a&l" + Sential.getInstance().getDescription().getName(),
                " &f* &7Version: &a" + Sential.getInstance().getDescription().getVersion(),
                " &f* &7Author: &a" + Sential.getInstance().getDescription().getAuthors().get(0),
                " &f* &7Discord: &a" + Sential.getInstance().getDescription().getWebsite(),
                " &f* &7Description: &a" + Sential.getInstance().getDescription().getDescription(),
                " &f* &7Github: &a" + "https://github.com/Cloudy-Development/Sential",
                ""
        );
        messages.forEach(message -> Bukkit.getConsoleSender().sendMessage(translate(message)));
    }

    /**
     * Send a message to the console when the plugin is disabled
     */
    public void sendDisableMessage() {
        List<String> messages = Arrays.asList(
                "",
                "&c&l" + Sential.getInstance().getDescription().getName() + " has been disabled.",
                ""
        );
        messages.forEach(message -> Bukkit.getConsoleSender().sendMessage(translate(message)));
    }
}
