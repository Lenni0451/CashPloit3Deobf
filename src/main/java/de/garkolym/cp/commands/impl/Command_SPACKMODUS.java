package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Command_SPACKMODUS extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_SPACKMODUS() {
        super("spackmodus", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler fängt nun an zu spacken!");
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler spackt nicht mehr.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (this.players.contains(e.getPlayer())) {
            e.getPlayer().teleport(e.getTo());
        }
    }

}
