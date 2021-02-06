package dev.hiitsdevin.devOSbot.commands.casual;

import dev.hiitsdevin.devOSbot.Main;
import dev.hiitsdevin.devOSbot.commands.BaseCommand;
import dev.hiitsdevin.devOSbot.commands.CommandCategory;
import dev.hiitsdevin.devOSbot.commands.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class Help extends BaseCommand {
    public Help() {
        super("help", CommandCategory.CASUAL);
    }

    @Override
    public void run(CommandContext ctx, List<String> args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Casual");
        eb.setTitle("Help you say? Here's the command list!");
        eb.addField("About", "Shows info about the bot", false);
        eb.addField("Ping", "Pong!", false);
        eb.addField("Hello", "Hello bot!", false);
        eb.addField("Shutdown", "Shutsdown the bot", false);
        eb.setColor(Main.color.usage);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).queue();
    }
}
