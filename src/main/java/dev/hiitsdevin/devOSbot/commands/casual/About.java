package dev.hiitsdevin.devOSbot.commands.casual;

import dev.hiitsdevin.devOSbot.Main;
import dev.hiitsdevin.devOSbot.commands.BaseCommand;
import dev.hiitsdevin.devOSbot.commands.CommandCategory;
import dev.hiitsdevin.devOSbot.commands.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.io.InputStream;
import java.util.List;

public class About extends BaseCommand {
    public About() {
        super("about", CommandCategory.CASUAL);
    }

    InputStream spiralStream = getClass().getClassLoader().getResourceAsStream("images/spiral.png");

    @Override
    public void run(CommandContext ctx, List<String> args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Casual");
        eb.setTitle("I am the devOS bot, your little in house bot, made for ...devOS");
        eb.addField("Authors", "Devin and Lizzy", false);
        eb.addField("JDA Version", JDAInfo.VERSION, false);
        eb.addField("Build Date", "February 5th, 2020", false);
        eb.setImage("attachment://spiral.png");
        eb.setColor(Main.color.general);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).addFile(spiralStream, "spiral.png").queue();
    }
}
