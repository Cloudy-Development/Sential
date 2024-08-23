package dev.cloudy.sential.api.command;

import dev.cloudy.sential.Sential;

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
