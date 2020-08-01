package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

class Command_HIDENENTITYS implements Runnable {

    final Command_HIDENENTITYS2 commandInstance;
    private final String[] args;
    private final Player player;

    Command_HIDENENTITYS(Command_HIDENENTITYS2 var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        Player vic = Bukkit.getPlayer(this.args[1]);

        for (Entity en : vic.getWorld().getEntities()) {
            ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(en.getEntityId()));
        }

        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler sieht nun keine Entitys mehr!");
    }

}
