package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class Command_TNTPlacer extends CommandBase implements Listener /* In the original code the implements Listener was missing. So this code has never worked? */ {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_TNTPlacer() {
        super("tntplacer", "<Spieler>" + " §d| " + ChatColor.GRAY + "Spieler plaziert TNT", Category.WORLD);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            if (!this.players.contains(p)) {
                this.players.add(p);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler plaziert jetzt nur TNT!");
            } else {
                this.players.remove(p);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler plaziert kein TNT mehr.");
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (this.players.contains(e.getPlayer())) {
            e.setCancelled(true);
            e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.PRIMED_TNT);
        }
    }

}
