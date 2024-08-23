package dev.cloudy.sential.feature.permission.command.impl;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.feature.permission.PermissionRepository;
import dev.cloudy.sential.util.CC;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 19:11
 */
public class PermissionListCommand extends BaseCommand {
    @Override
    @Command(name = "permission.list", permission = "sential.command.permission.list")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.sendMessage(CC.translate("&cUsage: /permission list <player>"));
            return;
        }

        Player target = player.getServer().getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        PermissionRepository permissionRepository = Sential.getInstance().getPermissionRepository();
        if (permissionRepository.getPlayerPerms(target).isEmpty()) {
            player.sendMessage(CC.translate("&c" + target.getName() + " has no permissions."));
            return;
        }

        player.sendMessage(CC.translate("&c&lPermissions of &4&l" + target.getName()));
        permissionRepository.getPlayerPerms(target).forEach(perm -> player.sendMessage(CC.translate("&c- &4" + perm)));
    }
}
