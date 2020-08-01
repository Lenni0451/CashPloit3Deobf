package de.garkolym.cp.commands.impl;

import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_CLEARCHAT extends CommandBase {

    public Command_CLEARCHAT() {
        super("clearchat", "-", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        for (Player user : Bukkit.getOnlinePlayers()) {
            for (int i = 0; i < 200; ++i) {
                user.sendMessage("");
            }
        }
    }

}
