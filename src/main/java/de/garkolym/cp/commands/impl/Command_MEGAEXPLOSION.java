package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;

class Command_MEGAEXPLOSION implements Runnable {

    final Command_MEGAEXPLOSION2 commandInstance;
    private final Player player;

    Command_MEGAEXPLOSION(Command_MEGAEXPLOSION2 var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        this.player.getWorld().createExplosion(this.player.getLocation(), 150.0F);
    }

}
