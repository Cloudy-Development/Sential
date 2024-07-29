package me.emmy.sential.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

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
}
