package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Command_TNTSCHOCK extends CommandBase {

    public Command_TNTSCHOCK() {
        super("tntschock", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);

                for (double x = vic.getLocation().getX() - 10.0D; x <= vic.getLocation().getX() + 10.0D; ++x) {
                    for (double y = vic.getLocation().getY() - 10.0D; y <= vic.getLocation().getY() + 10.0D; ++y) {
                        for (double z = vic.getLocation().getZ() - 10.0D; z <= vic.getLocation().getZ() + 10.0D; ++z) {
                            Location l = new Location(vic.getWorld(), x, y, z);
                            if (l.getBlock().getType().getId() != 0) {
                                vic.sendBlockChange(l, 46, (byte) 0);
                            }
                        }
                    }
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler besteht die Umgebung fast aus TNT :D");
            } catch (Exception ignored) {
            }
        }
    }

}
