package dev.hiitsdevin.devOSbot.commands;

public enum CommandCategory {
    CASUAL("casual"),
    FUN("fun"),
    MODERATION("moderation"),
    BOT("bot"),
    ;

    public String name;

    CommandCategory(String name) {
        this.name = name;
    }
}
