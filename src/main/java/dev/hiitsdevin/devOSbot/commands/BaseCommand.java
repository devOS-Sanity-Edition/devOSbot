package dev.hiitsdevin.devOSbot.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseCommand {
    public String label;
    public CommandCategory category;
    public ArrayList<String> aliases;

    public BaseCommand(String label, CommandCategory category, String... aliases) {
        this.label = label;
        this.category = category;
        this.aliases = new ArrayList<>(Arrays.asList(aliases));

        CommandManager.commandMap.put(label, this);
        for (String alias : this.aliases) CommandManager.commandAliasMap.put(alias, this.label);
    }

    public abstract void run(CommandContext ctx, List<String> args) throws InterruptedException;
}
