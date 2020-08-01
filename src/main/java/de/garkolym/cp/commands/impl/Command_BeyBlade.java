package de.garkolym.cp.commands.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;

class Command_BeyBlade implements Runnable {

    final Command_BeyBlade2 commandInstance;

    Command_BeyBlade(Command_BeyBlade2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player user : this.commandInstance.players) {
            user.teleport(new Location(user.getWorld(), user.getLocation().getX(), user.getLocation().getY(), user.getLocation().getZ(), (float) this.commandInstance.currentPitch, user.getLocation().getPitch()));
        }

        Command_BeyBlade2 var10000 = this.commandInstance;
        var10000.currentPitch += 4;
        if (this.commandInstance.currentPitch >= 360) {
            this.commandInstance.currentPitch = 0;
        }
    }

}
