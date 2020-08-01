package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_HEAL extends CommandBase {

    public Command_HEAL() {
        super("heal", "<Spieler>" + " §d| " + ChatColor.GRAY + "Heilung", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 1) {
            p.setHealth(20.0D);
            p.setFoodLevel(20);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du wurdest geheilt!");
        } else {
            Player victim = Bukkit.getPlayer(args[1]);
            victim.setHealth(20.0D);
            victim.setFoodLevel(20);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler wurde geheilt!");
        }
    }

}
