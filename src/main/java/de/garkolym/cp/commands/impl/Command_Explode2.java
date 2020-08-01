package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

class Command_Explode2 implements Runnable {

    final Command_Explode commandInstance;
    private final String[] args;
    private final Player player;

    Command_Explode2(Command_Explode var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        Player vic = Bukkit.getPlayer(this.args[1]);
        vic.getWorld().createExplosion(vic.getLocation(), 3.0F);
        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Eine Explosion ist beim Spieler aufgetreten.");
    }

}
