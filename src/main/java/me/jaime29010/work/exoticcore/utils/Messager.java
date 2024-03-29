package me.jaime29010.work.exoticcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public final class Messager {
    private final CommandSender sender;

    public Messager(CommandSender sender, String message) {
        this.sender = sender;
        send(message);
    }

    public Messager(CommandSender sender, String message, Object... args) {
        this.sender = sender;
        sendf(message, args);
    }

    public Messager(CommandSender sender, String message, Replacer replacer) {
        this.sender = sender;
        sendr(message, replacer);
    }

    public Messager(CommandSender sender, String... messages) {
        this.sender = sender;
        send(messages);
    }

    public static Messager send(CommandSender sender, String message) {
        return (new Messager(sender).send(message));
    }

    public static Messager sendf(CommandSender sender, String message, Object... args) {
        return (new Messager(sender).sendf(message, args));
    }

    public static Messager sendr(CommandSender sender, String message, Replacer replacer) {
        return (new Messager(sender).sendr(message, replacer));
    }

    public static Messager sendr(CommandSender sender, String message, String target, String replacement) {
        return (new Messager(sender).sendr(message, target, replacement));
    }

    public static Messager send(CommandSender sender, String... messages) {
        return (new Messager(sender).send(messages));
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public Messager send(String message) {
        if (sender != null) {
            sender.sendMessage(colorize(message));
        } else Bukkit.broadcastMessage(colorize(message));
        return this;
    }

    public Messager sendf(String message, Object... args) {
        send(String.format(message, args));
        return this;
    }

    public Messager sendr(String message, Replacer replacer) {
        send(replacer.replace(message));
        return this;
    }

    public Messager sendr(String message, String target, String replacement) {
        send(new Replacer(target, replacement).replace(message));
        return this;
    }

    public Messager send(String... messages) {
        for (String message : messages) {
            send(message);
        }
        return this;
    }

    public static final class Replacer {
        private final Map<String, String> replaces = new HashMap<>();

        public Replacer(String target, String replacement) {
            add(target, replacement);
        }

        public Replacer(Map<String, String> map) {
            replaces.putAll(map);
        }

        public static Replacer create(String target, String replacement) {
            return new Replacer(target, replacement);
        }

        public static Replacer create(Map<String, String> map) {
            return new Replacer(map);
        }

        public Replacer add(String target, String replacement) {
            replaces.put(target, replacement);
            return this;
        }

        public Map<String, String> getReplaces() {
            return replaces;
        }

        public String replace(String string) {
            for (Map.Entry<String, String> entry : replaces.entrySet()) {
                string = string.replace(entry.getKey(), colorize(entry.getValue()));
            }
            return string;
        }
    }
}
