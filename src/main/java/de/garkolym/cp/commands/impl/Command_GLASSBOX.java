package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Command_GLASSBOX extends CommandBase {

    public Command_GLASSBOX() {
        super("glassbox", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);

                double x;
                double y;
                double z;
                for (x = victim.getLocation().getX() - 5.0D; x <= victim.getLocation().getX() + 5.0D; ++x) {
                    for (y = victim.getLocation().getY() - 5.0D; y <= victim.getLocation().getY() + 5.0D; ++y) {
                        for (z = victim.getLocation().getZ() - 5.0D; z <= victim.getLocation().getZ() + 5.0D; ++z) {
                            victim.sendBlockChange(new Location(victim.getWorld(), x, y, z), 20, (byte) 0);
                        }
                    }
                }

                for (x = victim.getLocation().getX() - 4.0D; x <= victim.getLocation().getX() + 4.0D; ++x) {
                    for (y = victim.getLocation().getY() - 4.0D; y <= victim.getLocation().getY() + 4.0D; ++y) {
                        for (z = victim.getLocation().getZ() - 4.0D; z <= victim.getLocation().getZ() + 4.0D; ++z) {
                            victim.sendBlockChange(new Location(victim.getWorld(), x, y, z), 0, (byte) 0);
                        }
                    }
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler denkt jetzt, dass er in einer Glass-Box ist :)!");
            } catch (Exception ignored) {
            }
        }
    }

}
