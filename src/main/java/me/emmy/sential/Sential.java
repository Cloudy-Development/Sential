package me.emmy.sential;

import lombok.Getter;
import me.emmy.sential.command.HelpCommand;
import me.emmy.sential.util.command.CommandFramework;
import me.emmy.sential.command.AlertCommand;
import me.emmy.sential.command.GamemodeCommand;
import me.emmy.sential.command.HealCommand;
import me.emmy.sential.godmode.GodModeRepository;
import me.emmy.sential.godmode.command.GodModeCommand;
import me.emmy.sential.godmode.listener.GodModeListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class Sential extends JavaPlugin {

    @Getter
    private static Sential instance;

    private CommandFramework commandFramework;
    private GodModeRepository godModeRepository;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        commandFramework = new CommandFramework();
        godModeRepository = new GodModeRepository();

        Arrays.asList(
                new GamemodeCommand(),
                new GodModeCommand(),
                new HealCommand(),
                new AlertCommand(),
                new HelpCommand()
        ).forEach(commandFramework::registerCommands);

        getServer().getPluginManager().registerEvents(new GodModeListener(), this);

    }

    @Override
    public void onDisable() {
    }
}
