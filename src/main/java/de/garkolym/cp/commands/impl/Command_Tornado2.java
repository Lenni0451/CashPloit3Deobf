package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

import java.util.ArrayList;

public class Command_Tornado2 extends CommandBase implements Listener {

    private boolean enabled = false;
    private Location location = null;
    private int ticks = 0;
    private final ArrayList<FallingBlock> tornadoPieces = new ArrayList<>();

    public Command_Tornado2() {
        super("tornado", "-", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_Tornado(this), 1L, 1L);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            this.location = p.getLocation();
            this.enabled = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§aEin Tornado wurde gespawnt! Aus dem weg!");
        } else {
            this.enabled = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cDas Umwetter hat jetzt sein Ende.");
        }
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent e) {
        if (e.getBlock().getType().equals(Material.WEB)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
        }
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent e) {
        if (e.getBlock().getType().equals(Material.WEB)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
        }
    }

    static boolean isEnabledFromInstance(Command_Tornado2 var0) {
        return var0.enabled;
    }

    static int getTicksFromInstance(Command_Tornado2 var0) {
        return var0.ticks;
    }

    static Location getLocationFromInstance(Command_Tornado2 var0) {
        return var0.location;
    }

    static void setTicksOfInstance(Command_Tornado2 var0, int var1) {
        var0.ticks = var1;
    }

    static ArrayList<FallingBlock> getTornadoPiecesFromInstance(Command_Tornado2 var0) {
        return var0.tornadoPieces;
    }

}
