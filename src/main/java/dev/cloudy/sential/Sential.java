package dev.cloudy.sential;

import dev.cloudy.sential.api.command.CommandFramework;
import dev.cloudy.sential.feature.chat.management.ChatRepository;
import dev.cloudy.sential.feature.chat.management.command.ChatCommand;
import dev.cloudy.sential.feature.chat.format.listener.ChatListener;
import dev.cloudy.sential.player.command.SentialCommand;
import dev.cloudy.sential.player.command.admin.AlertCommand;
import dev.cloudy.sential.player.command.admin.GamemodeCommand;
import dev.cloudy.sential.player.command.admin.HealCommand;
import dev.cloudy.sential.player.command.user.HelpCommand;
import dev.cloudy.sential.feature.announcement.AnnouncementTask;
import dev.cloudy.sential.feature.godmode.GodModeRepository;
import dev.cloudy.sential.feature.godmode.command.GodModeCommand;
import dev.cloudy.sential.feature.godmode.listener.GodModeListener;
import dev.cloudy.sential.feature.permission.PermissionRepository;
import dev.cloudy.sential.feature.permission.command.PermissionCommand;
import dev.cloudy.sential.player.listener.JoinListener;
import dev.cloudy.sential.util.CC;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

@Getter
public class Sential extends JavaPlugin {

    @Getter
    private static Sential instance;

    private CommandFramework commandFramework;
    private GodModeRepository godModeRepository;
    private AnnouncementTask announcementTask;
    private PermissionRepository permissionRepository;
    private ChatRepository chatRepository;

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
        permissionRepository = new PermissionRepository();
        permissionRepository.loadPermissions();
        chatRepository = new ChatRepository(false);
    }

    private void registerCommands() {
        Arrays.asList(
                new SentialCommand(),
                new GamemodeCommand(),
                new GodModeCommand(),
                new HealCommand(),
                new AlertCommand(),
                new HelpCommand(),
                new PermissionCommand(),
                new ChatCommand()
        ).forEach(commandFramework::registerCommands);
    }

    private void registerListeners() {
        List<Listener> listeners = Arrays.asList(
                new JoinListener(),
                new GodModeListener(),
                new ChatListener()
        );
        listeners.forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    private void runTasks() {
        this.announcementTask = new AnnouncementTask();
        if (getConfig().getBoolean("announcement.enabled")) {
            int interval = getConfig().getInt("announcement.send-every");
            this.announcementTask.runTaskTimerAsynchronously(this, 20L * interval, 20L * interval);
        }
    }
}
