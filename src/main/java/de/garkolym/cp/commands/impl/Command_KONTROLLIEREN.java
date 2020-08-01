package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Iterator;

class Command_KONTROLLIEREN implements Runnable {

    final Command_KONTROLLIEREN3 commandInstance;
    private final String[] args;
    private final Player player;

    Command_KONTROLLIEREN(Command_KONTROLLIEREN3 var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            if (this.args.length == 2) {
                Player vic = Bukkit.getPlayer(this.args[1]);
                Player user;
                Iterator<? extends Player> var3;
                if (!this.commandInstance.players.containsKey(this.player)) {
                    this.commandInstance.players.put(this.player, vic);
                    this.player.teleport(vic);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + "Nun kontrollierst du " + ChatColor.LIGHT_PURPLE + vic.getName());
                    if (!Command_Vanish2.players.contains(this.player)) {
                        var3 = Bukkit.getOnlinePlayers().iterator();

                        while (var3.hasNext()) {
                            user = var3.next();
                            if (!user.equals(this.player)) {
                                user.hidePlayer(this.player);
                            }
                        }
                    }

                    this.player.hidePlayer(vic);
                } else {
                    this.commandInstance.players.remove(this.player);
                    this.player.sendMessage(Start.INSTANCE.chatPrefix + "Du kontrollierst nun keinen mehr!");
                    if (!Command_Vanish2.players.contains(this.player)) {
                        var3 = Bukkit.getOnlinePlayers().iterator();

                        while (var3.hasNext()) {
                            user = var3.next();
                            if (!user.equals(this.player)) {
                                user.showPlayer(this.player);
                            }
                        }
                    }

                    this.player.showPlayer(vic);
                }
            } else {
                this.commandInstance.players.remove(this.player);
                this.player.sendMessage(Start.INSTANCE.chatPrefix + "Du kontrollierst nun keinen mehr!");
            }
        } catch (Exception ignored) {
        }
    }

}
