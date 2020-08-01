package de.garkolym.cp.commands.impl;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

class Command_Granate2 implements Runnable {

    final Command_Granate commandInstance;
    private final Player player;

    Command_Granate2(Command_Granate var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        try {
            FallingBlock fb = this.player.getWorld().spawnFallingBlock(this.player.getLocation(), Material.COAL_BLOCK, (byte) 123);
            fb.setCustomName("GRANATE");
        } catch (Exception ignored) {
        }
    }

}
