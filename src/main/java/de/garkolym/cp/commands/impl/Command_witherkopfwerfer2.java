package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;

class Command_witherkopfwerfer2 implements Runnable {

    final Command_witherkopfwerfer commandInstance;

    Command_witherkopfwerfer2(Command_witherkopfwerfer var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player user : Command_witherkopfwerfer.getPlayersFromInstance(this.commandInstance)) {
            user.launchProjectile(WitherSkull.class);
        }
    }

}
