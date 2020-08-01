package de.garkolym.cp.commands.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;

class Command_NachObenGlotzer implements Runnable {

    final Command_NachObenGlotzer2 commandInstance;

    Command_NachObenGlotzer(Command_NachObenGlotzer2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_NachObenGlotzer2.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;
            if (user.getLocation().getPitch() != -90.0F) {
                user.teleport(new Location(user.getWorld(), user.getLocation().getX(), user.getLocation().getY(), user.getLocation().getZ(), user.getLocation().getYaw(), -90.0F));
            }
        }
    }

}
