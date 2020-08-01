package de.garkolym.cp.commands.impl;

import org.bukkit.Location;
import org.bukkit.entity.Player;

class Command_TNTVERFOLGER2 implements Runnable {

    final Command_TNTVERFOLGER commandInstance;

    Command_TNTVERFOLGER2(Command_TNTVERFOLGER var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player user : Command_TNTVERFOLGER.getPlayersFromInstance(this.commandInstance)) {
            Location lc = user.getLocation();
            lc.setY(lc.getY() + 5.0D);
            user.sendBlockChange(lc, 46, (byte) 0);
        }
    }

}
