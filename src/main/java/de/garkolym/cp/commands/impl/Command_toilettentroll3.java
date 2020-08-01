package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Command_toilettentroll3 extends CommandBase implements Listener {

    private boolean enabled = false;
    private int pitch = 0;
    private int ticks = 0;
    Location location = null;
    Location fallLocation = null;

    public Command_toilettentroll3() {
        super("toilettentroll", "-", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_toilettentroll2(this), 1L, 1L);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(Player p) {
        this.location = p.getLocation();
        this.location.setX(this.location.getX() - 20.0D);
        Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_toilettentroll(this, p));
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            this.execute(p);
            this.enabled = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§aToilette wurde gespawnt!");
            Location FallToilette = this.location;
            FallToilette.setY(FallToilette.getY() + 15.0D);
            this.fallLocation = FallToilette;

            for (Player user : Bukkit.getOnlinePlayers()) {
                if (!Start.INSTANCE.trustedPlayers.contains(user.getName())) {
                    user.teleport(FallToilette);
                }
            }
        } else {
            this.enabled = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cDer Schrecken hat aufgehört!");
        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (this.enabled && !Start.INSTANCE.trustedPlayers.contains(e.getPlayer().getName())) {
            e.setBuild(false);
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (this.enabled && !Start.INSTANCE.trustedPlayers.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }

    }

    static boolean isEnabledFromInstance(Command_toilettentroll3 var0) {
        return var0.enabled;
    }

    static int getPitchFromInstance(Command_toilettentroll3 var0) {
        return var0.pitch;
    }

    static void setPitchOfInstance(Command_toilettentroll3 var0, int var1) {
        var0.pitch = var1;
    }

    static int getTicksFromInstance(Command_toilettentroll3 var0) {
        return var0.ticks;
    }

    static void setTicksOfInstance(Command_toilettentroll3 var0, int var1) {
        var0.ticks = var1;
    }

}
