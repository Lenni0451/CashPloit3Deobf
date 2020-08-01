package de.garkolym.cp.commands.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;

class Command_WEBTROLL2 implements Runnable {

    final Command_WEBTROLL commandInstance;

    Command_WEBTROLL2(Command_WEBTROLL var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player user : Command_WEBTROLL.getPlayersFromInstance(this.commandInstance)) {
            user.sendBlockChange(user.getLocation(), Material.WEB.getId(), (byte) 0);
        }
    }

}
