package dev.hiitsdevin.devOSbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;

public class Main {
    private static final Yaml yaml = new Yaml();
    public static JDA jdaInstance;
    
    public static void main(String[] args) throws LoginException {
        Config config = yaml.loadAs(FileUtil.loadFileToString("config.yml"), Config.class);

        JDA jda = JDABuilder.createDefault(config.token).build();

        jdaInstance = jda;
    }
}
