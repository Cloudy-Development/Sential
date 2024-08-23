package dev.cloudy.sential.feature.godmode.command;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.feature.godmode.GodModeRepository;
import dev.cloudy.sential.util.CC;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 29/07/2024 - 19:51
 */
public class GodModeCommand extends BaseCommand {
    @Override
    @Command(name = "godmode", permission = "flower.command.godmode")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String [] args = command.getArgs();

        GodModeRepository godModeRepository = Sential.getInstance().getGodModeRepository();

        if (args.length < 1) {
            if (!godModeRepository.isGodModeEnabled(player)) {
                godModeRepository.enableGodMode(player);
                player.sendMessage(CC.translate("&aGod mode enabled."));
            } else {
                godModeRepository.disableGodMode(player);
                player.sendMessage(CC.translate("&cGod mode disabled."));
            }

            return;
        }

        Player targetPlayer = player.getServer().getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        if (!godModeRepository.isGodModeEnabled(targetPlayer)) {
            godModeRepository.enableGodMode(targetPlayer);
            player.sendMessage(CC.translate("&aGod mode enabled for " + targetPlayer.getName() + "."));
            targetPlayer.sendMessage(CC.translate("&aGod mode enabled."));
        } else {
            godModeRepository.disableGodMode(targetPlayer);
            player.sendMessage(CC.translate("&cGod mode disabled for " + targetPlayer.getName() + "."));
            targetPlayer.sendMessage(CC.translate("&cGod mode disabled."));
        }

    }
}
