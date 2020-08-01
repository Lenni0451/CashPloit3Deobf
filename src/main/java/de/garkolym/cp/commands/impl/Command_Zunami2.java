package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

class Command_Zunami2 implements Runnable {

    final Command_Zunami commandInstance;
    private final Player player;

    Command_Zunami2(Command_Zunami var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        for (double x = this.player.getLocation().getX() - 1.0D; x <= this.player.getLocation().getX() + 1.0D; ++x) {
            (new Location(this.player.getWorld(), x, this.player.getLocation().getY(), this.player.getLocation().getZ())).getBlock().setType(Material.WATER);
            (new Location(this.player.getWorld(), x, this.player.getLocation().getY(), this.player.getLocation().getZ())).getBlock().setData((byte) 8);
        }

        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Eine Zunami bricht aus!");
    }

}
