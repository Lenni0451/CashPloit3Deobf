package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

class Command_TROLLCREEPER2 implements Runnable {

    final Command_TROLLCREEPER commandInstance;
    private final Player player;

    Command_TROLLCREEPER2(Command_TROLLCREEPER var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        Creeper trollcreeeper = (Creeper) this.player.getWorld().spawnEntity(this.player.getLocation(), EntityType.CREEPER);
        trollcreeeper.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
        trollcreeeper.setPowered(true);
        FallingBlock tnt = this.player.getWorld().spawnFallingBlock(this.player.getLocation(), 46, (byte) 0);
        trollcreeeper.setPassenger(tnt);
    }

}
