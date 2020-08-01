package de.garkolym.cp.commands.impl;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;

import java.util.Iterator;

class Command_GriefHacke2 implements Runnable {

    final Command_GriefHacke commandInstance;

    Command_GriefHacke2(Command_GriefHacke var1) {
        this.commandInstance = var1;
    }

    public void run() {
        Iterator<ArmorStand> var2 = this.commandInstance.pickaxes.iterator();

        while (true) {
            ArmorStand Spitzhacke;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                Spitzhacke = var2.next();
            } while (Spitzhacke == null);

            Location lc = Spitzhacke.getLocation();
            lc.add(-0.3D, 0.0D, 0.0D);
            Spitzhacke.teleport(lc);

            for (double x = lc.getX() - 4.0D; x <= lc.getX() + 4.0D; ++x) {
                for (double y = lc.getY() - 4.0D; y <= lc.getY() + 4.0D; ++y) {
                    for (double z = lc.getZ() - 4.0D; z <= lc.getZ() + 4.0D; ++z) {
                        lc.getWorld().playEffect(new Location(lc.getWorld(), x, y, z), Effect.STEP_SOUND, (new Location(lc.getWorld(), x, y, z)).getBlock().getTypeId());
                        (new Location(lc.getWorld(), x, y, z)).getBlock().setType(Material.AIR);
                    }
                }
            }
        }
    }

}
