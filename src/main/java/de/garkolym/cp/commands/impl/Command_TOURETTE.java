package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;

import java.util.Random;

class Command_TOURETTE implements Runnable {

    final Command_TOURETTE2 commandInstance;

    Command_TOURETTE(Command_TOURETTE2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_TOURETTE2.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;
            user.chat(Command_TOURETTE2.getSwearsFromInstance(this.commandInstance).get((new Random()).nextInt(Command_TOURETTE2.getSwearsFromInstance(this.commandInstance).size())));
        }
    }

}
