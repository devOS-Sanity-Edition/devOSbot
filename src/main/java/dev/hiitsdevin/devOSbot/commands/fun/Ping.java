package dev.hiitsdevin.devOSbot.commands.fun;

import dev.hiitsdevin.devOSbot.Colors;
import dev.hiitsdevin.devOSbot.Main;
import dev.hiitsdevin.devOSbot.commands.BaseCommand;
import dev.hiitsdevin.devOSbot.commands.CommandCategory;
import dev.hiitsdevin.devOSbot.commands.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.util.List;

public class Ping extends BaseCommand {
    public Ping() {
        super("ping", CommandCategory.FUN);
    }

    @Override
    public void run(CommandContext ctx, List<String> args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Fun");
        eb.setTitle("Howdy nerd.");
        eb.setDescription("Pong! I work! Set me on fir- don't actually.");
        eb.setColor(Main.color.general);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).queue();
    }
}
