package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

class Command_GAMEMODE2 implements Runnable {

    final Command_GAMEMODE commandInstance;
    private final String[] args;
    private final Player player;

    Command_GAMEMODE2(Command_GAMEMODE var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            int Mode = Integer.parseInt(this.args[1]);
            switch (Mode) {
                case 0:
                    this.player.setGameMode(GameMode.SURVIVAL);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.YELLOW + "SURVIVAL");
                    break;
                case 1:
                    this.player.setGameMode(GameMode.CREATIVE);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.YELLOW + "CREATIVE");
                    break;
                case 2:
                    this.player.setGameMode(GameMode.ADVENTURE);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.YELLOW + "ADVENTURE");
                    break;
                case 3:
                    this.player.setGameMode(GameMode.SPECTATOR);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.YELLOW + "SPECTATOR");
                    break;
                default:
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + "§cFalsches GameMode!");
            }
        } catch (Exception ignored) {
        }
    }

}
