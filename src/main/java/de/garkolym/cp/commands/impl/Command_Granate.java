package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.util.Vector;

public class Command_Granate extends CommandBase implements Listener {

    public Command_Granate() {
        super("granate", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_Granate2(this, p));
        p.sendMessage(Start.INSTANCE.chatPrefix + "Die Granate wurde von dir geworfen!");
    }

    @EventHandler
    public void onBlockChangeByEntity(EntityChangeBlockEvent e) {
        try {
            if (e.getEntityType().equals(EntityType.FALLING_BLOCK)) {
                if (e.getEntity().getCustomName().equalsIgnoreCase("SPLITTER2")) {
                    e.setCancelled(true);
                    e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 6.0F);
                }

                int i;
                FallingBlock fb;
                FallingBlock fb2;
                FallingBlock fb3;
                FallingBlock fb4;
                if (e.getEntity().getCustomName().equalsIgnoreCase("SPLITTER")) {
                    e.setCancelled(true);

                    for (i = 0; i < 4; ++i) {
                        switch (i) {
                            case 0:
                                fb = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb.setCustomName("SPLITTER2");
                                fb.setVelocity(new Vector(0.5D, 0.05D, 0.0D));
                                break;
                            case 1:
                                fb2 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb2.setCustomName("SPLITTER2");
                                fb2.setVelocity(new Vector(-0.5D, 0.05D, 0.0D));
                                break;
                            case 2:
                                fb3 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb3.setCustomName("SPLITTER2");
                                fb3.setVelocity(new Vector(0.0D, 0.05D, 0.5D));
                                break;
                            case 3:
                                fb4 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb4.setCustomName("SPLITTER2");
                                fb4.setVelocity(new Vector(0.0D, 0.05D, -0.5D));
                        }

                        e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 6.0F);
                    }
                } else if (e.getEntity().getCustomName().equalsIgnoreCase("GRANATE")) {
                    e.setCancelled(true);

                    for (i = 0; i < 4; ++i) {
                        switch (i) {
                            case 0:
                                fb = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb.setCustomName("SPLITTER");
                                fb.setVelocity(new Vector(0.5D, 0.05D, 0.0D));
                                break;
                            case 1:
                                fb2 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb2.setCustomName("SPLITTER");
                                fb2.setVelocity(new Vector(-0.5D, 0.05D, 0.0D));
                                break;
                            case 2:
                                fb3 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb3.setCustomName("SPLITTER");
                                fb3.setVelocity(new Vector(0.0D, 0.05D, 0.5D));
                                break;
                            case 3:
                                fb4 = e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), Material.COAL_BLOCK, (byte) 77);
                                fb4.setCustomName("SPLITTER");
                                fb4.setVelocity(new Vector(0.0D, 0.05D, -0.5D));
                        }

                        e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 6.0F);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

}
