package dev.cloudy.sential.command;

import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 01/08/2024 - 06:34
 */
public class CraftCommand extends BaseCommand {
    @Override
    @Command(name = "craft", permission = "flower.command.craft")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.openWorkbench(player.getLocation(), true);
    }
}
