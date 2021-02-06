package dev.hiitsdevin.devOSbot;

import dev.hiitsdevin.devOSbot.commands.CommandManager;
import dev.hiitsdevin.devOSbot.commands.fun.About;
import dev.hiitsdevin.devOSbot.commands.fun.Hello;
import dev.hiitsdevin.devOSbot.commands.fun.Ping;
import dev.hiitsdevin.devOSbot.commands.fun.Shutdown;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.ObjectInputFilter;

public class Main {
    private static final Yaml yaml = new Yaml();
    public static Config config = yaml.loadAs(FileUtil.loadFileToString("config.yml"), Config.class);
    public static Colors color = yaml.loadAs(FileUtil.loadFileToString("colors.yml"), Colors.class);
    public static JDA jdaInstance;

    public static void main(String[] args) throws LoginException, InterruptedException {
        Runtime r = Runtime.getRuntime();

        r.addShutdownHook(new Thread(() -> {
            jdaInstance.shutdown();
            System.out.println("Bot shutting down...");
        }));

        JDABuilder builder = JDABuilder.createDefault(config.token)
                .addEventListeners(new CommandManager())
                .setActivity(Activity.watching("devOS live... barely."));

        new Ping();
        new Hello();
        new About();
        new Shutdown();

        jdaInstance = builder.build();
        jdaInstance.awaitReady();
    }

    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is up and ready!");
        }
    }
}
