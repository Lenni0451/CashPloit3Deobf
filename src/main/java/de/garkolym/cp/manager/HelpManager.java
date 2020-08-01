package de.garkolym.cp.manager;

import de.garkolym.cp.Start;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class HelpManager {

    public void UNUSED_METHOD(Player p) {
        for (int i = 0; i < 50; ++i) {
            p.sendMessage("");
        }
    }

    public void sendHelpPage(int Seite, Player p) {
        if (Seite == 0) {
            Seite = 1;
        }

        int max = Start.INSTANCE.commandManager.commands.size() / 5 + 1;
        if (Seite > max) {
            p.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.RED + "Es gibt nicht so viele Seiten!");
        } else {
            int i;
            for (i = 0; i < 40; ++i) {
                p.sendMessage("");
            }

            p.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.RED + " -- " + ChatColor.GOLD + "Funktionen: " + ChatColor.AQUA + Start.INSTANCE.commandManager.commands.size() + ChatColor.RED + " --");
            p.sendMessage(Start.INSTANCE.chatPrefix + ChatColor.RED + " -- " + ChatColor.YELLOW + "Seite " + ChatColor.GREEN + Seite + ChatColor.YELLOW + " von " + ChatColor.GREEN + (Start.INSTANCE.commandManager.commands.size() / 5 + 1) + ChatColor.RED + " --");

            for (i = (Seite - 1) * 5; i < (Seite - 1) * 5 + 5; ++i) {
                p.sendMessage(Start.INSTANCE.chatPrefix + Start.INSTANCE.commandManager.commands.get(i).getName() + ChatColor.LIGHT_PURPLE + " | " + Start.INSTANCE.commandManager.commands.get(i).getDescription());
            }
        }
    }

}
