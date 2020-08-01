package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_TP extends CommandBase {

    public Command_TP() {
        super("tp", "<Spieler> <Spieler>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                p.teleport(Bukkit.getPlayer(args[1]));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Erfolgreich teleportiert.");
            } catch (Exception ignored) {
            }
        } else if (args.length == 3) {
            try {
                Player p1 = Bukkit.getPlayer(args[1]);
                Player p2 = Bukkit.getPlayer(args[2]);
                p1.teleport(p2);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Erfolgreich teleportiert.");
            } catch (Exception ignored) {
            }
        }
    }

}
