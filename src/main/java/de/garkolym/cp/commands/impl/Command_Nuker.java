package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Command_Nuker extends CommandBase implements Listener {

    public ArrayList<Player> players = new ArrayList<>();

    public Command_Nuker() {
        super("nuker", ChatColor.GRAY + "In der Umgebung verschwinden Blöcke", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.players.contains(p)) {
            this.players.add(p);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du fängst an zu nuken!");
        } else {
            this.players.remove(p);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du hast aufgehört zu nuken!");
        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (Player user : this.players) {
            for (double x = user.getLocation().getX() - 4.0D; x <= user.getLocation().getX() + 4.0D; ++x) {
                for (double y = user.getLocation().getY() - 4.0D; y <= user.getLocation().getY() + 4.0D; ++y) {
                    for (double z = user.getLocation().getZ() - 4.0D; z <= user.getLocation().getZ() + 4.0D; ++z) {
                        try {
                            Location lc = new Location(user.getWorld(), x, y, z);
                            if (!lc.getBlock().getType().equals(Material.AIR)) {
                                lc.getBlock().setType(Material.AIR);
                            }
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
    }

}
