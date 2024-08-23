package dev.cloudy.sential.feature.chat.management.command;

import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.feature.chat.management.command.impl.ChatMuteCommand;
import dev.cloudy.sential.feature.chat.management.command.impl.ChatUnmuteCommand;
import dev.cloudy.sential.util.CC;
import org.bukkit.command.CommandSender;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:28
 */
public class ChatCommand extends BaseCommand {

    /**
     * Registers the chat mute and unmute commands.
     */
    public ChatCommand() {
        new ChatMuteCommand();
        new ChatUnmuteCommand();
    }

    @Override
    @Command(name = "chat", inGameOnly = false, permission = "sential.command.chat")
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage(CC.translate("&c&lChat Management"));
        sender.sendMessage(CC.translate(" &f* &7/chat mute &8- &cMute the chat"));
        sender.sendMessage(CC.translate(" &f* &7/chat unmute &8- &cUnmute the chat"));
    }
}
