package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;

class Command_TREE implements Runnable {

    final Command_TREE2 commandInstance;
    private final String[] args;
    private final Player player;

    Command_TREE(Command_TREE2 var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            Player vic = Bukkit.getPlayer(this.args[1]);
            Location lc = vic.getLocation();
            lc.setY(lc.getY() - 1.0D);
            lc.getBlock().setType(Material.GRASS);
            lc.setY(lc.getY() + 1.0D);
            lc.getWorld().generateTree(lc, TreeType.JUNGLE);
            this.player.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler wurde ein Baum gespawnt!");
        } catch (Exception ignored) {
        }
    }

}
