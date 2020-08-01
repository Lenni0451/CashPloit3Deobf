package de.garkolym.cp.commands.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashSet;

class Command_LookNuker implements Runnable {

    final Command_LookNuker2 commandInstance;

    private Command_LookNuker(Command_LookNuker2 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : Command_LookNuker2.getPlayersFromInstance(this.commandInstance)) {
            Player user = (Player) o;
            user.getTargetBlock((HashSet<Byte>) null, 200).getLocation().getBlock().setType(Material.AIR);
        }
    }

    Command_LookNuker(Command_LookNuker2 var1, Command_LookNuker var2) {
        this(var1);
    }

}
