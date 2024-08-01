package me.emmy.sential.command;

import me.emmy.sential.util.command.BaseCommand;
import me.emmy.sential.util.command.CommandArgs;
import me.emmy.sential.util.command.annotation.Command;
import me.emmy.sential.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 31/07/2024 - 18:58
 */
public class HealCommand extends BaseCommand {
    @Override
    @Command(name = "heal", permission = "flower.command.heal")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String [] args = command.getArgs();

        if (args.length < 1) {
            player.sendMessage(CC.translate("&aYou have been healed."));
            player.setHealth(20);
            player.setFoodLevel(20);
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        target.setHealth(20);
        target.setFoodLevel(20);
        target.sendMessage(CC.translate("&aYou have been healed."));
        player.sendMessage(CC.translate("&aYou have healed &e" + target.getName() + "."));
    }
}
