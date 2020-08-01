package de.garkolym.cp.commands.impl;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

class Command_SoundSpam implements Runnable {

    final Command_SoundSpam2 commandInstance;

    Command_SoundSpam(Command_SoundSpam2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        try {
            for (Object o : Command_SoundSpam2.getPlayersFromInstance(this.commandInstance)) {
                Player user = (Player) o;
                user.playSound(user.getLocation(), Sound.BAT_DEATH, 0.2F, 2.14748365E9F);
            }
        } catch (Exception ignored) {
        }
    }

}
