package dev.cloudy.sential.player.command;

import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.util.info.ProjectInfo;
import dev.cloudy.sential.util.CC;
import org.bukkit.command.CommandSender;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 20:03
 */
public class SentialCommand extends BaseCommand {
    @Override
    @Command(name = "sential", inGameOnly = false)
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage("");
        sender.sendMessage(CC.translate("&c&lSential &7- &cBasic Essentials Plugin"));
        sender.sendMessage(CC.translate(" &f* &7Author: &c" + ProjectInfo.AUTHOR));
        sender.sendMessage(CC.translate(" &f* &7Version: &c" + ProjectInfo.VERSION));
        sender.sendMessage(CC.translate(" &f* &7Discord: &c" + ProjectInfo.DISCORD_LINK));
        sender.sendMessage(CC.translate(" &f* &7Github: &c" + ProjectInfo.GITHUB_LINK));
        sender.sendMessage(CC.translate(" &f* &7Description: &c" + ProjectInfo.DESCRIPTION));
        sender.sendMessage("");
    }
}
