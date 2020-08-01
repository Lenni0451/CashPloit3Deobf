package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

class Command_HARDSTYLER2 implements Runnable {

    final Command_HARDSTYLER commandInstance;

    Command_HARDSTYLER2(Command_HARDSTYLER var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_HARDSTYLER.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;
            if (user.isOnGround()) {
                user.setVelocity(new Vector(0.0D, 0.13D, 0.0D));
            }
        }
    }

}
