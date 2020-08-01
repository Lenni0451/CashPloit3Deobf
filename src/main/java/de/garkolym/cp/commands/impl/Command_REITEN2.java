package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

class Command_REITEN2 implements Runnable {

    final Command_REITEN commandInstance;
    private final String[] args;
    private final Player player;

    Command_REITEN2(Command_REITEN var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        Player opfer = Bukkit.getPlayer(this.args[1]);
        Player pferd = Bukkit.getPlayer(this.args[2]);
        Entity cart = opfer.getWorld().spawnEntity(opfer.getLocation(), EntityType.MINECART);
        opfer.setPassenger(cart);
        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Der Spieler reitet nun auf den anderen Spieler!");
    }

}
