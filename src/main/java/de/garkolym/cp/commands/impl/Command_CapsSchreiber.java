package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class Command_CapsSchreiber extends CommandBase implements Listener {

    public ArrayList<Player> players = new ArrayList<>();

    public Command_CapsSchreiber() {
        super("capsschreiber", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler schreibt nur mit Caps!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler schreibt nicht mehr mit Caps!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (this.players.contains(p)) {
            e.setMessage(e.getMessage().toUpperCase());
        }
    }

}
