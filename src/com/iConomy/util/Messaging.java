package com.iConomy.util;

import com.iConomy.iConomy;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messaging
{
  private static CommandSender sender = null;

  public static String argument(String original, Object[] arguments, Object[] points)
  {
    for (int i = 0; i < arguments.length; i++) {
      if (String.valueOf(arguments[i]).contains(",")) {
        for (String arg : String.valueOf(arguments[i]).split(","))
          original = original.replace(arg, String.valueOf(points[i]));
      }
      else {
        original = original.replace(String.valueOf(arguments[i]), String.valueOf(points[i]));
      }
    }

    return original;
  }

  public static String parse(String original)
  {
    original = colorize(original);
    return original.replaceAll("(&([a-z0-9]))", "§$2").replace("&&", "&");
  }

  public static String colorize(String original)
  {
    original = original.replace("`r", "§c");
    original = original.replace("`R", "§4");
    original = original.replace("`y", "§e");
    original = original.replace("`Y", "§6");
    original = original.replace("`g", "§a");
    original = original.replace("`G", "§2");
    original = original.replace("`a", "§b");
    original = original.replace("`A", "§3");
    original = original.replace("`b", "§9");
    original = original.replace("`B", "§1");
    original = original.replace("`p", "§d");
    original = original.replace("`P", "§5");
    original = original.replace("`k", "§0");
    original = original.replace("`s", "§7");
    original = original.replace("`S", "§8");
    original = original.replace("`w", "§f");

    return original.replace("<black>", "§0")
      .replace("<navy>", "§1")
      .replace("<green>", "§2")
      .replace("<teal>", "§3")
      .replace("<red>", "§4")
      .replace("<purple>", "§5")
      .replace("<gold>", "§6")
      .replace("<silver>", "§7")
      .replace("<gray>", "§8")
      .replace("<blue>", "§9")
      .replace("<lime>", "§a")
      .replace("<aqua>", "§b")
      .replace("<rose>", "§c")
      .replace("<pink>", "§d")
      .replace("<yellow>", "§e")
      .replace("<white>", "§f");
  }

  public static String bracketize(String message)
  {
    return "[" + message + "]";
  }

  public static void save(Player player)
  {
    sender = player;
  }

  public static void save(CommandSender sender)
  {
    Messaging.sender = sender;
  }

  public static void send(Player player, String message)
  {
    player.sendMessage(parse(message));
  }

  public static void send(CommandSender sender, String message)
  {
    sender.sendMessage(parse(message));
  }

  public static void send(String message)
  {
    if (sender != null)
      sender.sendMessage(parse(message));
  }

  public static void broadcast(String message)
  {
    for (Player p : iConomy.getBukkitServer().getOnlinePlayers())
      p.sendMessage(parse(message));
  }
}