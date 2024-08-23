package dev.cloudy.sential.command;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.util.CC;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 01/08/2024 - 06:36
 */
public class HelpCommand extends BaseCommand {
    @Override
    @Command(name = "help")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String message : Sential.getInstance().getConfig().getStringList("help")) {
            player.sendMessage(CC.translate(message));
        }
    }
}
