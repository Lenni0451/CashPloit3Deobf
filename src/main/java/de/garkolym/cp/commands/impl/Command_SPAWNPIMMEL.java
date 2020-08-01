package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Command_SPAWNPIMMEL extends CommandBase {

    public Command_SPAWNPIMMEL() {
        super("spawnpimmel", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);

                double x;
                double y;
                double z;
                for (x = vic.getLocation().getX() - 4.0D; x <= vic.getLocation().getX() + 4.0D; ++x) {
                    for (y = vic.getLocation().getY() + 4.0D; y <= vic.getLocation().getY() + 6.0D; ++y) {
                        for (z = vic.getLocation().getZ(); z <= vic.getLocation().getZ() + 2.0D; ++z) {
                            vic.sendBlockChange(new Location(vic.getWorld(), x, y, z), Material.WOOL, (byte) 6);
                        }
                    }
                }

                for (x = vic.getLocation().getX() - 1.0D; x <= vic.getLocation().getX() + 1.0D; ++x) {
                    for (y = vic.getLocation().getY() + 6.0D; y <= vic.getLocation().getY() + 12.0D; ++y) {
                        for (z = vic.getLocation().getZ(); z <= vic.getLocation().getZ() + 2.0D; ++z) {
                            vic.sendBlockChange(new Location(vic.getWorld(), x, y, z), Material.WOOL, (byte) 6);
                        }
                    }
                }

                for (x = vic.getLocation().getX() - 1.0D; x <= vic.getLocation().getX() + 1.0D; ++x) {
                    for (y = vic.getLocation().getY() + 12.0D; y <= vic.getLocation().getY() + 14.0D; ++y) {
                        for (z = vic.getLocation().getZ(); z <= vic.getLocation().getZ() + 2.0D; ++z) {
                            vic.sendBlockChange(new Location(vic.getWorld(), x, y, z), Material.WOOL, (byte) 2);
                        }
                    }
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler erscheint (Client-Side) ein Pimmel.");
            } catch (Exception ignored) {
            }
        }
    }

}
