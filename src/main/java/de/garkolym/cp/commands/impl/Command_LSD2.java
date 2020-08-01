package de.garkolym.cp.commands.impl;

import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Iterator;

class Command_LSD2 implements Runnable {

    final Command_LSD commandInstance;

    Command_LSD2(Command_LSD var1) {
        this.commandInstance = var1;
    }

    public void run() {
        Player victim;
        Iterator<Player> var2;
        if (Command_LSD.getColorStateFromInstance(this.commandInstance)) {
            var2 = Command_LSD.getPlayersFromInstance(this.commandInstance).iterator();

            while (var2.hasNext()) {
                victim = var2.next();
                ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 5.0F));
            }

            Command_LSD.setColorStateOfInstance(this.commandInstance, false);
        } else {
            var2 = Command_LSD.getPlayersFromInstance(this.commandInstance).iterator();

            while (var2.hasNext()) {
                victim = var2.next();
                ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 0.0F));
            }

            Command_LSD.setColorStateOfInstance(this.commandInstance, true);
        }

    }
}
