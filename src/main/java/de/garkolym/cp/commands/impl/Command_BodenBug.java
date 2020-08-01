package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Command_BodenBug extends CommandBase {

    public Command_BodenBug() {
        super("bodenbug", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);

                for (double x = vic.getLocation().getX() - 10.0D; x <= vic.getLocation().getX() + 10.0D; ++x) {
                    for (double y = vic.getLocation().getY() - 10.0D; y <= vic.getLocation().getY() + 10.0D; ++y) {
                        for (double z = vic.getLocation().getZ() - 10.0D; z <= vic.getLocation().getZ() + 10.0D; ++z) {
                            if (!(new Location(vic.getWorld(), x, y, z)).getBlock().getType().equals(Material.AIR)) {
                                vic.sendBlockChange(new Location(vic.getWorld(), x, y, z), 0, (byte) 0);
                            }
                        }
                    }
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Sein Boden verschwindet unter Fuß :)");
            } catch (Exception ignored) {
            }
        }
    }

}
