package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class Command_COMMANDSPY extends CommandBase implements Listener {

    public static ArrayList<Player> players = new ArrayList<>();

    public Command_COMMANDSPY() {
        super("commandspy", ChatColor.GRAY + "Fremde Befehle sehen", Category.OTHER);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!players.contains(p)) {
            players.add(p);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du siehst nun andere Befehle!");
        } else {
            players.remove(p);
            p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt siehst du keine Befehle mehr!");
        }

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        for (Player user : players) {
            if (!e.getPlayer().equals(user)) {
                user.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.RED + e.getPlayer().getName() + ChatColor.DARK_GREEN + "] " + ChatColor.LIGHT_PURPLE + e.getMessage());
            }
        }
    }

}
