package dev.cloudy.sential.locale;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.util.CC;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.List;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 20:20
 */
@Getter
public enum Locale {

    EXAMPLE("path-from-config"),

    ;

    private final String path;

    Locale(String path) {
        this.path = path;
    }

    public String getString() {
        if (path == null) {
            return "path is null";
        }
        return Sential.getInstance().getConfig().getString(path);
    }

    public List<String> getStringList() {
        if (path == null) {
            return Arrays.asList("StringList path is null", "Good luck fixing it!");
        }
        return Sential.getInstance().getConfig().getStringList(path);
    }

    public int getInt() {
        if (path == null) {
            Bukkit.getConsoleSender().sendMessage(CC.translate("&cInteger path is null"));
            return 0;
        }
        return Sential.getInstance().getConfig().getInt(path);
    }

    public boolean getBoolean() {
        if (path == null) {
            Bukkit.getConsoleSender().sendMessage(CC.translate("&cBoolean result is null"));
            return false;
        }
        return Sential.getInstance().getConfig().getBoolean(path);
    }
}
