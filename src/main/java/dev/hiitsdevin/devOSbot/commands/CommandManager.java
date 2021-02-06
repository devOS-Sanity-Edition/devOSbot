package dev.hiitsdevin.devOSbot.commands;

import dev.hiitsdevin.devOSbot.Main;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Message;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getAuthor().isBot()) return;

        if (!msg.getContentRaw().toLowerCase().startsWith(Main.config.prefix)) return;
        ArrayList<String> args = new ArrayList<>(Arrays.asList(msg.getContentRaw().substring(Main.config.prefix.length()).split("\\s+")));

        String command = args.remove(0);

        BaseCommand cmd;

        if (commandMap.containsKey(command))
            cmd = commandMap.get(command);
        else if (commandAliasMap.containsKey(command))
            cmd = commandMap.get(commandAliasMap.get(command));
        else return;

        if (cmd == null) return;

        CommandContext ctx = new CommandContext();
        ctx.message = msg;

        try {
            cmd.run(ctx, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, BaseCommand> commandMap = new HashMap<>();
    public static HashMap<String, String> commandAliasMap = new HashMap<>();
}
