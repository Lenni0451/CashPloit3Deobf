package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Command_TNTRun extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_TNTRun() {
        super("tntrun", "<Spieler>", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler läuft nun mit TNT!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler läuft nicht mehr mit TNT rum.");
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (this.players.contains(p)) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
        }
    }

}
