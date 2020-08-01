package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_FAKEMSG extends CommandBase {

    public Command_FAKEMSG() {
        super("fakemsg", "<Spieler> <Spieler> <Nachricht>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length > 3) {
            Player Absender = Bukkit.getPlayer(args[1]);
            Player Bekommer = Bukkit.getPlayer(args[2]);
            String Nachricht = "";

            for (int i = 3; i < args.length; ++i) {
                Nachricht = Nachricht + args[i] + " ";
            }

            Bekommer.sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + Absender.getName() + ChatColor.GOLD + " -> " + ChatColor.RED + "me" + ChatColor.GOLD + "] " + ChatColor.WHITE + Nachricht);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Die Nachricht wurde abgeschickt :)");
        }
    }

}
