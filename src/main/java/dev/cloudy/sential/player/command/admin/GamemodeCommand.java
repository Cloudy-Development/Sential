package dev.cloudy.sential.player.command.admin;

import dev.cloudy.sential.api.command.CommandArgs;
import dev.cloudy.sential.api.command.annotation.Command;
import dev.cloudy.sential.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @author Emmy
 * @project Sential
 * @date 29/07/2024 - 19:54
 */
public class GamemodeCommand {
    @Command(name = "gmc", aliases = {"gm.c", "gamemode.c", "gm.1", "gm1", "gamemode.1", "gamemode.creative"}, permission = "tulip.command.gmc")
    public void onGamemodeCreative(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(CC.translate("&aYour gamemode has been updated to Creative."));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        targetPlayer.setGameMode(GameMode.CREATIVE);
        player.sendMessage(CC.translate("&aYou have updated &e" + targetPlayer.getName() + "'s &agamemode to Creative."));
        targetPlayer.sendMessage(CC.translate("&aYour gamemode has been updated to Creative."));
    }

    @Command(name = "gms", aliases = {"gm.s", "gamemode.s", "gm.0", "gm0", "gamemode.0", "gamemode.survival"}, permission = "tulip.command.gms")
    public void onGamemodeSurvival(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(CC.translate("&aYour gamemode has been updated to Survival."));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        targetPlayer.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(CC.translate("&aYou have updated &e" + targetPlayer.getName() + "'s &agamemode to Survival."));
        targetPlayer.sendMessage(CC.translate("&aYour gamemode has been updated to Survival."));
    }

    @Command(name = "gma", aliases = {"gm.a", "gamemode.a", "gm.2", "gm2", "gamemode.2", "gamemode.adventure"}, permission = "tulip.command.gma")
    public void onGamemodeAdventure(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.setGameMode(GameMode.ADVENTURE);
            player.sendMessage(CC.translate("&aYour gamemode has been updated to Adventure."));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        targetPlayer.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(CC.translate("&aYou have updated &e" + targetPlayer.getName() + "'s &agamemode to Adventure."));
        targetPlayer.sendMessage(CC.translate("&aYour gamemode has been updated to Adventure."));
    }

    @Command(name = "gmsp", aliases = {"gm.sp", "gamemode.sp", "gm.3", "gm3", "gamemode.3", "gamemode.spectator"}, permission = "tulip.command.gmsp")
    public void onGamemodeSpectator(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length < 1) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(CC.translate("&aYour gamemode has been updated to Spectator."));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(CC.translate("&cPlayer not found."));
            return;
        }

        targetPlayer.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(CC.translate("&aYou have updated &e" + targetPlayer.getName() + "'s &agamemode to Spectator."));
        targetPlayer.sendMessage(CC.translate("&aYour gamemode has been updated to Spectator."));
    }
}
