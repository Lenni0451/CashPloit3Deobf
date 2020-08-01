package de.garkolym.cp.commands.impl;

import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_BROADCAST extends CommandBase {

    public Command_BROADCAST() {
        super("broadcast", "<Nachricht>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        String Nachricht = "";

        for (int i = 1; i < args.length; ++i) {
            Nachricht = Nachricht + args[i].replace("&", "§") + " ";
        }

        Bukkit.broadcastMessage(Nachricht);
    }

}
