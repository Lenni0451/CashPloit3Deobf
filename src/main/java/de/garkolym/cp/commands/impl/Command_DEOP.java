package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_DEOP extends CommandBase {

    public Command_DEOP() {
        super("deop", "<Spieler>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 1) {
            p.setOp(false);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du hast keine OP Rechte mehr!");
        } else if (args.length == 2) {
            try {
                Bukkit.getPlayer(args[1]).setOp(false);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler hat keine OP Rechte mehr!");
            } catch (Exception var4) {
                p.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.RED + "Dieser Spieler ist nicht online!");
            }
        } else {
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cBitte überprüfe deine Syntax.");
        }
    }

}
