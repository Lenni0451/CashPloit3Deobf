package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.Iterator;

class Command_MassRegen2 implements Runnable {

    final Command_MassRegen commandInstance;
    private final Player player;

    Command_MassRegen2(Command_MassRegen var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        Iterator<String> var2 = Start.INSTANCE.trustedPlayers.iterator();

        int ChunkPosX;
        while (var2.hasNext()) {
            String user = var2.next();

            try {
                for (ChunkPosX = 0; ChunkPosX < 40; ++ChunkPosX) {
                    Bukkit.getPlayer(user).sendMessage("");
                }

                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "§aUmgebung wird zurückgesetzt!");
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "§bBitte warten Sie, gleich wirds lustig :)");
            } catch (Exception ignored) {
            }
        }

        Chunk[] Chunks = this.player.getWorld().getLoadedChunks();

        int i;
        for (Chunk chunk : Chunks) {
            ChunkPosX = chunk.getX();
            i = chunk.getZ();
            this.player.getWorld().regenerateChunk(ChunkPosX, i);
            this.player.getWorld().refreshChunk(ChunkPosX, i);
            this.player.getWorld().unloadChunk(ChunkPosX, i);
            this.player.getWorld().loadChunk(ChunkPosX, i);
        }

        for (String user : Start.INSTANCE.trustedPlayers) {
            try {
                for (i = 0; i < 40; ++i) {
                    Bukkit.getPlayer(user).sendMessage("");
                }

                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "§dUmgebung wurde erfolgreich zurückgesetzt!");
            } catch (Exception ignored) {
            }
        }

        Command_MassRegen.setEnabled(false);
    }

}
