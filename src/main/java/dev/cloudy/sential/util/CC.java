package dev.cloudy.sential.util;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.util.info.ProjectInfo;
import lombok.experimental.UtilityClass;
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
     * unTranslate a string with color codes
     *
     * @param text The text to unTranslate
     * @return The unTranslated text
     */
    public String unTranslate(String text) {
        return ChatColor.stripColor(text);
    }

    /**
     * Send a message to the console when the locale is enabled
     */
    public void sendEnableMessage() {
        List<String> messages = Arrays.asList(
                "",
                "&c&l" + Sential.getInstance().getDescription().getName() + " &7- &cBasic Essentials Plugin",
                " &f* &7Version: &c" + ProjectInfo.VERSION,
                " &f* &7Author: &c" + ProjectInfo.AUTHOR,
                " &f* &7Discord: &c" + ProjectInfo.DISCORD_LINK,
                " &f* &7Github: &c" + ProjectInfo.GITHUB_LINK,
                " &f* &7Description: &c" + ProjectInfo.DESCRIPTION,
                ""
        );
        messages.forEach(message -> Bukkit.getConsoleSender().sendMessage(translate(message)));
    }

    /**
     * Send a message to the console when the locale is disabled
     */
    public void sendDisableMessage() {
        List<String> messages = Arrays.asList(
                "",
                "&c&l" + ProjectInfo.NAME + " has been disabled.",
                ""
        );
        messages.forEach(message -> Bukkit.getConsoleSender().sendMessage(translate(message)));
    }
}
