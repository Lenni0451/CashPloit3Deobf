package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;

class Command_ENDLOSKILL implements Runnable {

    final Command_ENDLOSKILL2 commandInstance;

    Command_ENDLOSKILL(Command_ENDLOSKILL2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_ENDLOSKILL2.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;
            user.setHealth(0.0D);
        }
    }

}
