package dev.cloudy.sential.feature.chat.command.impl;

import dev.cloudy.sential.Sential;
import dev.cloudy.sential.api.command.BaseCommand;
import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.util.CC;
import org.bukkit.command.CommandSender;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:30
 */
public class ChatMuteCommand extends BaseCommand {
    @Override
    @Command(name = "chat.mute", permission = "sential.command.chat.mute")
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        if (Sential.getInstance().getChatRepository().isChatMuted()) {
            sender.sendMessage(CC.translate("&cThe chat is already muted."));
            return;
        }
        
        Sential.getInstance().getChatRepository().setChatMuted(true);
        sender.sendMessage(CC.translate("&aYou've muted the chat."));
    }
}
