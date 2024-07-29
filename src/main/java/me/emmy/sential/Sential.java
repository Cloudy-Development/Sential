package me.emmy.sential;

import lombok.Getter;
import me.emmy.sential.api.command.CommandFramework;
import me.emmy.sential.command.GamemodeCommand;
import me.emmy.sential.godmode.GodModeRepository;
import me.emmy.sential.godmode.command.GodModeCommand;
import me.emmy.sential.godmode.listener.GodModeListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Getter
public class Sential extends JavaPlugin {

    @Getter
    private static Sential instance;

    private GodModeRepository godModeRepository;
    private CommandFramework commandFramework;

    @Override
    public void onEnable() {
        instance = this;

        godModeRepository = new GodModeRepository();
        commandFramework = new CommandFramework();

        Arrays.asList(
                new GamemodeCommand(),
                new GodModeCommand()
        ).forEach(commandFramework::registerCommands);

        getServer().getPluginManager().registerEvents(new GodModeListener(), this);

    }

    @Override
    public void onDisable() {
    }
}
