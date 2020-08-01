package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Command_TNTRakete extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_TNTRakete() {
        super("tntrakete", "<Spieler>" + " §d| " + ChatColor.GRAY + "Mit TNT hochfliegen", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler fliegt jetzt mit TNT hoch!");
                    vic.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler fliegt nicht mehr mit TNT hoch!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (Player user : this.players) {
            user.setVelocity(new Vector(0.0D, 0.4D, 0.0D));
            user.getWorld().spawnEntity(user.getLocation(), EntityType.PRIMED_TNT);
        }
    }

}
