package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_GAMEMODE extends CommandBase {

    public Command_GAMEMODE() {
        super("gm", "<Spieler> <ID>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_GAMEMODE2(this, args, p));
            } catch (Exception ignored) {
            }
        } else if (args.length == 3) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_GAMEMODE3(this, args, p));
            } catch (Exception ignored) {
            }
        }
    }

}
