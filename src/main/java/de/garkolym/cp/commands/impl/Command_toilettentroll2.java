package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.utils.MathAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Iterator;

class Command_toilettentroll2 implements Runnable {

    final Command_toilettentroll3 command;

    Command_toilettentroll2(Command_toilettentroll3 var1) {
        this.command = var1;
    }

    public void run() {
        if (Command_toilettentroll3.isEnabledFromInstance(this.command)) {
            Iterator<? extends Player> var2 = Bukkit.getOnlinePlayers().iterator();

            while (true) {
                Player user;
                do {
                    if (!var2.hasNext()) {
                        if (Command_toilettentroll3.getPitchFromInstance(this.command) > 360) {
                            Command_toilettentroll3.setPitchOfInstance(this.command, 0);
                        }

                        if (Command_toilettentroll3.getTicksFromInstance(this.command) > 3) {
                            Command_toilettentroll3.setTicksOfInstance(this.command, 0);
                        }

                        Command_toilettentroll3 var10000 = this.command;
                        Command_toilettentroll3.setTicksOfInstance(var10000, Command_toilettentroll3.getTicksFromInstance(var10000) + 1);
                        var10000 = this.command;
                        Command_toilettentroll3.setPitchOfInstance(var10000, Command_toilettentroll3.getPitchFromInstance(var10000) + 12);
                        return;
                    }

                    user = var2.next();
                } while (Start.INSTANCE.trustedPlayers.contains(user.getName()));

                if ((user.getLocation().getX() > this.command.location.getX() + 7.0D || user.getLocation().getX() < this.command.location.getX() - 7.0D) && (user.getLocation().getZ() > this.command.location.getZ() + 7.0D || user.getLocation().getZ() < this.command.location.getZ() - 7.0D)) {
                    user.teleport(this.command.fallLocation);
                }

                if (user.getLocation().getBlock().getTypeId() != 8 && user.getLocation().getBlock().getTypeId() != 9) {
                    user.teleport(new Location(user.getWorld(), user.getLocation().getX(), user.getLocation().getY(), user.getLocation().getZ(), (float) Command_toilettentroll3.getPitchFromInstance(this.command), user.getLocation().getPitch()));
                    user.setVelocity(new Vector(0, -1, 0));
                } else {
                    user.setVelocity(new Vector(MathAPI.nextNumberBetween(-1, 1), -1, MathAPI.nextNumberBetween(-1, 1)));
                }
            }
        }
    }
}
