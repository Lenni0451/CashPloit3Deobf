package de.garkolym.cp.commands.impl;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;

class Command_Atombombe implements Runnable {

    final Command_Atombombe2 commandInstance;
    private final Player player;

    Command_Atombombe(Command_Atombombe2 var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        try {
            FallingBlock fb = this.player.getWorld().spawnFallingBlock(this.player.getLocation(), Material.SPONGE, (byte) 123);
            fb.setCustomName("GRANATE");
        } catch (Exception ignored) {
        }
    }

}
