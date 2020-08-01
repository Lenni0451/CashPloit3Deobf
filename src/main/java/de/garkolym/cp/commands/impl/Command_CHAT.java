package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_CHAT extends CommandBase {

    public Command_CHAT() {
        super("chat", "<Nachricht>" + " §d| " + ChatColor.GRAY + "Lokaler Chat", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length > 1) {
            String msg = "";

            for (int i = 1; i < args.length; ++i) {
                msg = msg + args[i] + " ";
            }

            for (String user : Start.INSTANCE.trustedPlayers) {
                try {
                    Bukkit.getPlayer(user).sendMessage(ChatColor.AQUA + "[CHAT] " + ChatColor.RED + "[" + p.getName() + "] " + ChatColor.YELLOW + msg);
                } catch (Exception ignored) {
                }
            }
        }
    }

}
