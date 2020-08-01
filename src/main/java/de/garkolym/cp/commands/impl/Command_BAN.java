package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_BAN extends CommandBase {

    public Command_BAN() {
        super("ban", "<Spieler>" + " §d| " + ChatColor.GRAY + "Sperren", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        Bukkit.broadcastMessage(args[1]);
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_BAN2(this, args));
            } catch (Exception var5) {
                Bukkit.broadcastMessage(var5.getMessage());
            }
        } else {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_BAN3(this, args));
            } catch (Exception var4) {
                Bukkit.broadcastMessage(var4.getMessage());
            }
        }
    }

}
