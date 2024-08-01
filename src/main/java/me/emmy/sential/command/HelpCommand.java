package me.emmy.sential.command;

import me.emmy.sential.Sential;
import me.emmy.sential.util.CC;
import me.emmy.sential.util.command.BaseCommand;
import me.emmy.sential.util.command.CommandArgs;
import me.emmy.sential.util.command.annotation.Command;
import org.bukkit.entity.Player;

import java.util.List;

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
