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

public class Hello extends BaseCommand {
    public Hello() {
        super("hello", CommandCategory.CASUAL);
    }

    @Override
    public void run(CommandContext ctx, List<String> args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Casual");
        eb.setTitle("Hello!");
        eb.setDescription("I am the devOS bot, your local, devOS only friend! Don't hurt me please!");
        eb.setColor(Main.color.general);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).queue();
    }
}
