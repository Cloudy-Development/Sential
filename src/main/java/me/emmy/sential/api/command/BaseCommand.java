package me.emmy.sential.api.command;

import me.emmy.sential.Sential;

/**
 * @author minnymin3
 */
public abstract class BaseCommand {

    public Sential main = Sential.getInstance();

    public BaseCommand() {
        main.getCommandFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
