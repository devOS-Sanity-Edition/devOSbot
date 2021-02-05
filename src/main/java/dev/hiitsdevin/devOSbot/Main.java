package dev.hiitsdevin.devOSbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;

public class Main {
    private static final Yaml yaml = new Yaml();
    public static JDA jdaInstance;
    
    public static void main(String[] args) throws LoginException {
        Runtime r = Runtime.getRuntime();

        r.addShutdownHook(new Thread() {
            public void run() {
                jdaInstance.shutdown();
                System.out.println("haha nuka cola'd- oh fuCK");
            }
        });

        Config config = yaml.loadAs(FileUtil.loadFileToString("config.yml"), Config.class);

        JDABuilder builder = JDABuilder.createDefault(config.token);
        builder.setActivity(Activity.watching("devOS live... barely."));

        jdaInstance = builder.build();
    }
}
