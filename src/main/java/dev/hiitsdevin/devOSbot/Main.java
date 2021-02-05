package dev.hiitsdevin.devOSbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;

public class Main {
    private static final Yaml yaml = new Yaml();
    public static JDA jdaInstance;
    
    public static void main(String[] args) throws Exception {
        Runtime r = Runtime.getRuntime();

        r.addShutdownHook(new Thread() {
            public void run() {
                jdaInstance.shutdown();
                System.out.println("Bot shutting down...");
            }
        });

        Config config = yaml.loadAs(FileUtil.loadFileToString("config.yml"), Config.class);

        JDABuilder builder = JDABuilder.createDefault(config.token);
        builder.setActivity(Activity.watching("devOS live... barely."));
        builder.addEventListeners(new MyListener());

        jdaInstance = builder.build();

        jdaInstance.awaitReady();
    }

    public static class MyListener extends ListenerAdapter {
        public void onMessageRecieved(MessageReceivedEvent event) {
            if (event.getAuthor().isBot()) return;

            Message message = event.getMessage();
            String content = message.getContentDisplay();

            if (content.equals("d!ping")) {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Ponged! I am in devOS!").queue();
            }
        }
    }

    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is up and ready!");
        }
    }
}
