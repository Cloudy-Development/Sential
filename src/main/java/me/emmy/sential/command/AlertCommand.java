package me.emmy.sential.command;

import me.emmy.sential.Sential;
import me.emmy.sential.util.command.BaseCommand;
import me.emmy.sential.util.command.CommandArgs;
import me.emmy.sential.util.command.annotation.Command;
import me.emmy.sential.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

/**
 * @author Emmy
 * @project Sential
 * @date 31/07/2024 - 19:01
 */
public class AlertCommand extends BaseCommand {
    @Override
    @Command(name = "alert", permission = "flower.command.alert", inGameOnly = false)
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length < 1) {
            sender.sendMessage(CC.translate("&cUsage: /alert <message>"));
            return;
        }

        String message = String.join(" ", Arrays.copyOfRange(args, 0, args.length));

        for (String alert : Sential.getInstance().getConfig().getStringList("alert-format")) {
            Bukkit.broadcastMessage(CC.translate(alert.replace("{msg}", message)));
        }
    }
}