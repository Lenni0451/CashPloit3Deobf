package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Iterator;

class Command_Vanish implements Runnable {

    final Command_Vanish2 commandInstance;
    private final Player player;

    Command_Vanish(Command_Vanish2 var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        try {
            Player user;
            Iterator<? extends Player> var2;
            if (!Command_Vanish2.players.contains(this.player)) {
                Command_Vanish2.players.add(this.player);
                var2 = Bukkit.getOnlinePlayers().iterator();

                while (true) {
                    do {
                        if (!var2.hasNext()) {
                            this.player.sendMessage(Start.INSTANCE.chatPrefix + "§aDu bist nun im Vanish!");
                            return;
                        }

                        user = var2.next();
                    } while (user == this.player && Command_Vanish2.players.contains(user));

                    user.hidePlayer(this.player);
                }
            } else {
                Command_Vanish2.players.remove(this.player);
                var2 = Bukkit.getOnlinePlayers().iterator();

                while (var2.hasNext()) {
                    user = var2.next();
                    if (user != this.player) {
                        user.showPlayer(this.player);
                    }
                }

                this.player.sendMessage(Start.INSTANCE.chatPrefix + "§cDu bist nicht mehr im Vanish!");
            }
        } catch (Exception ignored) {
        }
    }

}
