package dev.cloudy.sential.feature.permission.command;

import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.feature.permission.command.impl.PermissionAddCommand;
import dev.cloudy.sential.feature.permission.command.impl.PermissionListCommand;
import dev.cloudy.sential.feature.permission.command.impl.PermissionRemoveCommand;
import dev.cloudy.sential.util.CC;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 19:10
 */
public class PermissionCommand extends BaseCommand {

    /**
     * Constructor for the PermissionCommand class that initializes the permission add, remove, and list commands.
     */
    public PermissionCommand() {
        new PermissionAddCommand();
        new PermissionRemoveCommand();
        new PermissionListCommand();
    }
    
    @Override
    @Command(name = "permission", permission = "sential.command.permission")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        
        player.sendMessage(CC.translate("&c&lPermission Attachment"));
        player.sendMessage(CC.translate("&7- &c/permission add <player> <permission>"));
        player.sendMessage(CC.translate("&7- &c/permission remove <player> <permission>"));
        player.sendMessage(CC.translate("&7- &c/permission list <player>"));
    }
}
