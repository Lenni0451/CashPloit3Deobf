package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_TNTRegen2 extends CommandBase {

    public Command_TNTRegen2() {
        super("tntregen", "<Spieler>" + " §d| " + ChatColor.GRAY + "Viel TNT wird gespawnt", Category.WORLD);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_TNTRegen(this, args, p));
        }
    }

}
