package de.garkolym.cp.commands.impl;

import de.garkolym.cp.utils.MathAPI;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.util.Vector;

class Command_Tornado implements Runnable {

    final Command_Tornado2 commandInstance;

    Command_Tornado(Command_Tornado2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        if (Command_Tornado2.isEnabledFromInstance(this.commandInstance)) {
            if (Command_Tornado2.getTicksFromInstance(this.commandInstance) == 3) {
                Command_Tornado2.getLocationFromInstance(this.commandInstance).add(MathAPI.nextNumberBetween(-1, 1), 0.0D, MathAPI.nextNumberBetween(-1, 1));
                Command_Tornado2.setTicksOfInstance(this.commandInstance, 0);
            }

            Command_Tornado2 var10000 = this.commandInstance;
            Command_Tornado2.setTicksOfInstance(var10000, Command_Tornado2.getTicksFromInstance(var10000) + 1);
            Location tmp = Command_Tornado2.getLocationFromInstance(this.commandInstance);
            tmp.getWorld().playSound(tmp, Sound.BLAZE_BREATH, 4.6F, 0.6F);

            for (double x = Command_Tornado2.getLocationFromInstance(this.commandInstance).getX() - 1.0D; x <= Command_Tornado2.getLocationFromInstance(this.commandInstance).getX() + 1.0D; ++x) {
                for (double z = Command_Tornado2.getLocationFromInstance(this.commandInstance).getZ() - 1.0D; z <= Command_Tornado2.getLocationFromInstance(this.commandInstance).getZ() + 1.0D; ++z) {
                    tmp.setY(tmp.getWorld().getHighestBlockYAt(tmp));
                    FallingBlock fb = tmp.getWorld().spawnFallingBlock(new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY(), z), Material.WEB.getId(), (new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY() - 1.0D, z)).getBlock().getData());
                    fb.setVelocity(new Vector(0, 2, 0));

                    while (Command_Tornado2.getTornadoPiecesFromInstance(this.commandInstance).size() > 200) {
                        Command_Tornado2.getTornadoPiecesFromInstance(this.commandInstance).get(0).remove();
                        Command_Tornado2.getTornadoPiecesFromInstance(this.commandInstance).remove(0);
                    }

                    Command_Tornado2.getTornadoPiecesFromInstance(this.commandInstance).add(fb);
                    int id = (new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY() - 1.0D, z)).getBlock().getTypeId();
                    byte data = (new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY() - 1.0D, z)).getBlock().getData();
                    (new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY() - 1.0D, z)).getBlock().setType(Material.AIR);
                    FallingBlock bla = tmp.getWorld().spawnFallingBlock(new Location(Command_Tornado2.getLocationFromInstance(this.commandInstance).getWorld(), x, tmp.getY() + 1.0D, z), id, data);
                    bla.setVelocity(new Vector(MathAPI.nextNumberBetween(-1, 1), MathAPI.nextNumberBetween(1, 2), MathAPI.nextNumberBetween(-1, 1)));
                }
            }
        }
    }

}
