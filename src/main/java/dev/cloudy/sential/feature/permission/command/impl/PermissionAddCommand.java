package dev.cloudy.sential.feature.permission.command.impl;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.feature.permission.PermissionRepository;
import dev.cloudy.sential.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 19:11
 */
public class PermissionAddCommand extends BaseCommand {
    @Override
    @Command(name = "permission.add", permission = "sential.command.permission.add")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 2) {
            player.sendMessage(CC.translate("&cUsage: /permission add <player> <permission>"));
            return;
        }

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        if (target == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        PermissionRepository permissionRepository = Sential.getInstance().getPermissionRepository();
        if (permissionRepository.hasPermission(target.getName(), args[1])) {
            player.sendMessage(CC.translate("&c" + target.getName() + " already has that permission attached."));
            return;
        }

        permissionRepository.addPermission(target.getName(), args[1]);
        player.sendMessage(CC.translate("&aYou've added the permission &e" + args[1] + " &ato &e" + target.getName() + "&a."));
    }
}
