package de.garkolym.cp.commands.impl;

import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

class Command_VIRUS implements Runnable {

    final Command_VIRUS2 commandInstance;

    Command_VIRUS(Command_VIRUS2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_VIRUS2.getPlayersFromInstance(this.commandInstance).keySet()) {
            Player user = (Player) o;
            ((CraftPlayer) user).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 5.0F));
            user.sendTitle("§a§lVirus wird entpackt ...", "§l" + Command_VIRUS2.getPlayersFromInstance(this.commandInstance).get(user) + "%");
            Command_VIRUS2.getPlayersFromInstance(this.commandInstance).put(user, Command_VIRUS2.getPlayersFromInstance(this.commandInstance).get(user) + 1);
            if (Command_VIRUS2.getPlayersFromInstance(this.commandInstance).get(user) > 100) {
                Command_VIRUS2.getPlayersFromInstance(this.commandInstance).remove(user);
                ((CraftPlayer) user).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 0.0F));
            }
        }
    }

}
