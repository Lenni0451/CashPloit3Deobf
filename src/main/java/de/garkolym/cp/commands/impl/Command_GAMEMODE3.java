package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

class Command_GAMEMODE3 implements Runnable {

    final Command_GAMEMODE commandInstance;
    private final String[] args;
    private final Player player;

    Command_GAMEMODE3(Command_GAMEMODE var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            Player vic = Bukkit.getPlayer(this.args[2]);
            int Mode = Integer.parseInt(this.args[1]);
            switch (Mode) {
                case 0:
                    vic.setGameMode(GameMode.SURVIVAL);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + vic.getName() + " ist jetzt im " + ChatColor.YELLOW + "SURVIVAL" + "§f" + " Mode!");
                    break;
                case 1:
                    vic.setGameMode(GameMode.CREATIVE);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + vic.getName() + " ist jetzt im " + ChatColor.YELLOW + "CREATIVE" + "§f" + " Mode!");
                    break;
                case 2:
                    vic.setGameMode(GameMode.ADVENTURE);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + vic.getName() + " ist jetzt im " + ChatColor.YELLOW + "ADVENTURE" + "§f" + " Mode!");
                    break;
                case 3:
                    vic.setGameMode(GameMode.SPECTATOR);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + vic.getName() + " ist jetzt im " + ChatColor.YELLOW + "SPECTATOR" + "§f" + " Mode!");
                    break;
                default:
                    vic.sendMessage(Start.INSTANCE.chatPrefix + "§cFalsches GameMode!");
            }
        } catch (Exception ignored) {
        }
    }

}
