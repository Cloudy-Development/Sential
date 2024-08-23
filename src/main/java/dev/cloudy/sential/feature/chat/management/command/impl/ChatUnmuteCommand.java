package dev.cloudy.sential.feature.chat.management.command.impl;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.util.CC;
import org.bukkit.command.CommandSender;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:31
 */
public class ChatUnmuteCommand extends BaseCommand {
    @Override
    @Command(name = "chat.unmute", permission = "sential.command.chat.unmute")
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        if (!Sential.getInstance().getChatRepository().isChatMuted()) {
            sender.sendMessage(CC.translate("&cThe chat is already unmuted."));
            return;
        }

        Sential.getInstance().getChatRepository().setChatMuted(false);
        sender.sendMessage(CC.translate("&aYou've unmuted the chat."));
    }
}
