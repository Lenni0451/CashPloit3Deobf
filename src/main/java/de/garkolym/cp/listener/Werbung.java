package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;

public class Werbung implements Runnable {

    public void run() {
        for (String user : Start.INSTANCE.trustedPlayers) {
            try {
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "Wenn dir das Plugin gefällt");
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "§bDann abonniere §cGarkolym §bauf Youtube");
                Bukkit.getPlayer(user).sendMessage(Start.INSTANCE.chatPrefix + "Er macht Grief Videos :)");
            } catch (Exception ignored) {
            }
        }
    }

}
