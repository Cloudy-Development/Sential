package dev.cloudy.sential.feature.announcement;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AnnouncementTask handles sending announcements based on configuration.
 * It loads announcements and sends them randomly.
 *
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 18:56
 */
public class AnnouncementTask extends BukkitRunnable {

    private final List<Announcement> announcements = new ArrayList<>();
    private final Random random = new Random();

    public AnnouncementTask() {
        loadAnnouncements();
    }

    @Override
    public void run() {
        if (announcements.isEmpty()) {
            return;
        }

        for (String line : announcements.get(random.nextInt(announcements.size())).getLines()) {
            Bukkit.broadcastMessage(CC.translate(line));
        }
    }

    public void loadAnnouncements() {
        FileConfiguration config = Sential.getInstance().getConfig();

        announcements.clear();

        for (String key : config.getConfigurationSection("announcement.list").getKeys(false)) {
            List<String> list = config.getStringList("announcement.list." + key);
            announcements.add(new Announcement(list));
        }
    }
}
