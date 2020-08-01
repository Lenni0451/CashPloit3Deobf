package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

class Command_TNTRegen implements Runnable {

    final Command_TNTRegen2 commandInstance;
    private final String[] args;
    private final Player player;

    Command_TNTRegen(Command_TNTRegen2 var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            Player victim = Bukkit.getPlayer(this.args[1]);

            for (double x = victim.getLocation().getX() - 5.0D; x <= victim.getLocation().getX() + 5.0D; ++x) {
                for (double z = victim.getLocation().getZ() - 5.0D; z <= victim.getLocation().getZ() + 5.0D; ++z) {
                    victim.getWorld().spawnEntity(new Location(victim.getWorld(), x, victim.getLocation().getY() + 8.0D, z), EntityType.PRIMED_TNT);
                }
            }

            this.player.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler regnet es TNT! :D");
        } catch (Exception var6) {
            Bukkit.broadcastMessage(var6.getMessage());
        }
    }

}
