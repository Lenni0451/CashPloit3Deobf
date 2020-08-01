package de.garkolym.cp.commands.impl;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

class Command_PARTICLEFUCKER2 implements Runnable {

    final Command_PARTICLEFUCKER commandInstance;

    Command_PARTICLEFUCKER2(Command_PARTICLEFUCKER var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player vic : Command_PARTICLEFUCKER.getPlayersFromInstance(this.commandInstance)) {
            for (int i = 0; i < 100; ++i) {
                vic.playEffect(vic.getLocation(), Effect.ENDER_SIGNAL, 1);
                vic.playEffect(vic.getLocation(), Effect.LARGE_SMOKE, 1);
                vic.playEffect(vic.getLocation(), Effect.EXPLOSION_LARGE, 1);
                vic.playEffect(vic.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                vic.playEffect(vic.getLocation(), Effect.STEP_SOUND, 1);
                vic.playEffect(vic.getLocation(), Effect.CLOUD, 1);
                vic.playSound(vic.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
            }
        }
    }

}
