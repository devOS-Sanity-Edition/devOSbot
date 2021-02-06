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

public class Shutdown extends BaseCommand {
    public Shutdown() {
        super("shutdown", CommandCategory.BOT);
    }

    @Override
    public void run(CommandContext ctx, List<String> args) throws InterruptedException {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Bot");
        eb.setTitle("Shutting down bot.");
        eb.setColor(Main.color.critical);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).queue();

        Thread.sleep(500);

        Main.jdaInstance.shutdown();
        System.exit(0);
    }
}
