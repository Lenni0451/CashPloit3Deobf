package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_MassRegen extends CommandBase {

    private static boolean enabled = false;

    public Command_MassRegen() {
        super("weltreset", "-", Category.WORLD);
    }

    public void execute(String[] args, Player p) {
        if (!enabled) {
            enabled = true;
            Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_MassRegen2(this, p));
        }
    }

    static void setEnabled(boolean var0) {
        enabled = var0;
    }

}
