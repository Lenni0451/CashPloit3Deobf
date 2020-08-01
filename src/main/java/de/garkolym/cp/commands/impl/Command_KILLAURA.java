package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

class Command_KILLAURA implements Runnable {

    final Command_KILLAURA2 commandInstance;

    Command_KILLAURA(Command_KILLAURA2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Player user : this.commandInstance.players) {
            for (Entity en : user.getWorld().getEntities()) {
                try {
                    if (!en.isDead() && user.getLocation().distance(en.getLocation()) < 3.9D && en instanceof LivingEntity && !en.getName().equalsIgnoreCase(user.getName())) {
                        ((LivingEntity) en).damage(0.5D);
                        en.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }

}
