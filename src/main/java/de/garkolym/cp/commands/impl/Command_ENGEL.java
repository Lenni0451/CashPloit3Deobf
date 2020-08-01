package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Command_ENGEL extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_ENGEL() {
        super("engel", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler verhält sich jetzt wie ein Engel!");
                    vic.setVelocity(new Vector(0.0D, 0.8D, 0.0D));
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler verhält sich nicht mehr wie ein Engel :(");
                }
            } catch (Exception ignored) {
            }
        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (Player user : this.players) {
            user.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
        }
    }

}
