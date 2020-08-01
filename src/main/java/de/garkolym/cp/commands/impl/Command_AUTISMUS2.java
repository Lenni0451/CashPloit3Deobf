package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import net.minecraft.server.v1_8_R3.EnumDifficulty;
import net.minecraft.server.v1_8_R3.PacketPlayOutRespawn;
import net.minecraft.server.v1_8_R3.WorldSettings.EnumGamemode;
import net.minecraft.server.v1_8_R3.WorldType;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

class Command_AUTISMUS2 implements Runnable {

    final Command_AUTISMUS commandInstance;
    private final String[] args;
    private final Player player;

    Command_AUTISMUS2(Command_AUTISMUS var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        Player vic = Bukkit.getPlayer(this.args[1]);
        vic.setFlying(true);

        for (int i = 0; i < 50; ++i) {
            ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutRespawn(1, EnumDifficulty.HARD, WorldType.NORMAL_1_1, EnumGamemode.NOT_SET));
        }

        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Er ist in seinem Bewusst verfangen.");
    }

}
