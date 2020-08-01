package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class Command_PissRakete extends CommandBase implements Listener {

    public ArrayList<Player> players = new ArrayList<>();

    public Command_PissRakete() {
        super("pissrakete", "<Spieler>" + " §d| " + ChatColor.GRAY + "Pisst sich hoch", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler pisst sich jetzt hoch!");
                    victim.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler hat nun aufgehört.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (Player user : this.players) {
            try {
                user.setVelocity(new Vector(0.0D, 0.3D, 0.0D));
                user.getWorld().playSound(user.getLocation(), Sound.FIZZ, 5.0F, 5.0F);
                user.getWorld().spawnFallingBlock(user.getLocation(), Material.WOOL, (byte) 4);
            } catch (Exception ignored) {
            }
        }
    }

}
