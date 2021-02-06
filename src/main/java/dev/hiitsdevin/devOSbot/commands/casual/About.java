package dev.hiitsdevin.devOSbot.commands.casual;

import dev.hiitsdevin.devOSbot.Colors;
import dev.hiitsdevin.devOSbot.Main;
import dev.hiitsdevin.devOSbot.commands.BaseCommand;
import dev.hiitsdevin.devOSbot.commands.CommandCategory;
import dev.hiitsdevin.devOSbot.commands.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class About extends BaseCommand {
    public About() {
        super("about", CommandCategory.CASUAL);
    }

    @Override
    public void run(CommandContext ctx, List<String> args) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setFooter("devOS: Sanity Edition | Casual");
        eb.setTitle("I am the devOS bot, your little inhouse bot, made for ...devOS");
        eb.addField("Authors", "Devin and Lizzy", false);
        eb.addField("JDA Version", "v4.2.0", false);
        eb.addField("Build Date", "February 5th, 2020", false);
        eb.setImage("https://cdn.discordapp.com/splashes/631566179277864964/02fa731a7a093a10e768a0dd46db296c.png?size=4096");
        eb.setColor(Main.color.general);

        MessageChannel channel = ctx.message.getChannel();
        channel.sendMessage(eb.build()).queue();
    }
}
