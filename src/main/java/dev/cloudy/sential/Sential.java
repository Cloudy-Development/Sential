package dev.cloudy.sential;

import lombok.Getter;
import dev.cloudy.sential.api.command.CommandFramework;
import dev.cloudy.sential.command.AlertCommand;
import dev.cloudy.sential.command.GamemodeCommand;
import dev.cloudy.sential.command.HealCommand;
import dev.cloudy.sential.command.HelpCommand;
import dev.cloudy.sential.feature.announcement.AnnouncementTask;
import dev.cloudy.sential.feature.godmode.GodModeRepository;
import dev.cloudy.sential.feature.godmode.command.GodModeCommand;
import dev.cloudy.sential.feature.godmode.listener.GodModeListener;
import dev.cloudy.sential.util.CC;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class Sential extends JavaPlugin {

    @Getter
    private static Sential instance;

    private CommandFramework commandFramework;
    private GodModeRepository godModeRepository;
    private AnnouncementTask announcementTask;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        registerCommandFramework();
        registerRepositories();
        registerCommands();
        registerListeners();
        runTasks();

        CC.sendEnableMessage();
    }

    @Override
    public void onDisable() {
        CC.sendDisableMessage();
    }

    private void registerCommandFramework() {
        commandFramework = new CommandFramework();
    }

    private void registerRepositories() {
        godModeRepository = new GodModeRepository();
    }

    private void registerCommands() {
        Arrays.asList(
                new GamemodeCommand(),
                new GodModeCommand(),
                new HealCommand(),
                new AlertCommand(),
                new HelpCommand()
        ).forEach(commandFramework::registerCommands);
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new GodModeListener(), this);
    }

    private void runTasks() {
        this.announcementTask = new AnnouncementTask();
        if (getConfig().getBoolean("announcement.enabled")) {
            int interval = getConfig().getInt("announcement.send-every");
            this.announcementTask.runTaskTimerAsynchronously(this, 20L * interval, 20L * interval);
        }
    }
}
