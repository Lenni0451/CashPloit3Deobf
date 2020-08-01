package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

class Command_toilettentroll implements Runnable {

    final Command_toilettentroll3 commandInstance;
    private final Player player;

    Command_toilettentroll(Command_toilettentroll3 var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        try {
            Location tSP = this.player.getLocation();
            tSP.setX(tSP.getX() - 20.0D);
            tSP.setY(tSP.getWorld().getHighestBlockYAt(tSP));

            double x;
            double y;
            double z;
            for (x = tSP.getX() - 2.0D; x <= tSP.getX() + 2.0D; ++x) {
                for (y = tSP.getY() - 0.0D; y <= tSP.getY() + 2.0D; ++y) {
                    for (z = tSP.getZ() - 2.0D; z <= tSP.getZ() + 2.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.QUARTZ_BLOCK);
                    }
                }
            }

            for (x = tSP.getX() - 3.0D; x <= tSP.getX() + 3.0D; ++x) {
                for (y = tSP.getY() + 3.0D; y <= tSP.getY() + 2.0D + 2.0D; ++y) {
                    for (z = tSP.getZ() - 3.0D; z <= tSP.getZ() + 3.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.QUARTZ_BLOCK);
                    }
                }
            }

            for (x = tSP.getX() - 4.0D; x <= tSP.getX() + 4.0D; ++x) {
                for (y = tSP.getY() + 5.0D; y <= tSP.getY() + 5.0D; ++y) {
                    for (z = tSP.getZ() - 4.0D; z <= tSP.getZ() + 4.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.QUARTZ_BLOCK);
                    }
                }
            }

            for (x = tSP.getX() - 5.0D; x <= tSP.getX() + 5.0D; ++x) {
                for (y = tSP.getY() + 6.0D; y <= tSP.getY() + 6.0D; ++y) {
                    for (z = tSP.getZ() - 5.0D; z <= tSP.getZ() + 5.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.QUARTZ_BLOCK);
                    }
                }
            }

            for (x = tSP.getX() - 3.0D; x <= tSP.getX() + 3.0D; ++x) {
                for (y = tSP.getY() + 5.0D; y <= tSP.getY() + 5.0D; ++y) {
                    for (z = tSP.getZ() - 3.0D; z <= tSP.getZ() + 3.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.AIR);
                    }
                }
            }

            for (x = tSP.getX() - 4.0D; x <= tSP.getX() + 4.0D; ++x) {
                for (y = tSP.getY() + 6.0D; y <= tSP.getY() + 6.0D; ++y) {
                    for (z = tSP.getZ() - 4.0D; z <= tSP.getZ() + 4.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.WATER);
                    }
                }
            }

            for (x = tSP.getX() - 5.0D; x <= tSP.getX() - 5.0D; ++x) {
                for (y = tSP.getY() + 7.0D; y <= tSP.getY() + 18.0D; ++y) {
                    for (z = tSP.getZ() - 5.0D; z <= tSP.getZ() + 5.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.QUARTZ_BLOCK);
                    }
                }
            }

            for (x = tSP.getX() - 5.0D; x <= tSP.getX() - 5.0D; ++x) {
                for (y = tSP.getY() + 7.0D; y <= tSP.getY() + 7.0D + 1.0D; ++y) {
                    for (z = tSP.getZ() - 4.0D; z <= tSP.getZ() + 4.0D; ++z) {
                        (new Location(tSP.getWorld(), x, y, z)).getBlock().setType(Material.AIR);
                    }
                }
            }
        } catch (Exception var8) {
            Bukkit.broadcastMessage(var8.getMessage());
        }
    }

}
