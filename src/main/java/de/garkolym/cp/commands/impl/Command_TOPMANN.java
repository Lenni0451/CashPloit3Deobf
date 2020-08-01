package de.garkolym.cp.commands.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;

class Command_TOPMANN implements Runnable {

    final Command_TOPMANN2 commandInstance;

    Command_TOPMANN(Command_TOPMANN2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_TOPMANN2.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;

            try {
                if (user.getLocation().getY() < (double) user.getWorld().getHighestBlockYAt(user.getLocation())) {
                    user.teleport(new Location(user.getWorld(), user.getLocation().getX(), user.getWorld().getHighestBlockYAt(user.getLocation()), user.getLocation().getZ(), user.getLocation().getYaw(), user.getLocation().getPitch()));
                }
            } catch (Exception ignored) {
            }
        }
    }

}
