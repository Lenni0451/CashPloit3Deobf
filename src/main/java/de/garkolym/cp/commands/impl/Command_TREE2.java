package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_TREE2 extends CommandBase {

    public Command_TREE2() {
        super("tree", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_TREE(this, args, p));
        }
    }

}
