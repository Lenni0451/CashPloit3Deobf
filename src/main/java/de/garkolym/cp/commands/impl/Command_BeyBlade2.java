package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_BeyBlade2 extends CommandBase {

    public ArrayList<Player> players = new ArrayList<>();
    public int currentPitch = 0;

    public Command_BeyBlade2() {
        super("beyblade", "<Spieler>" + " §d| " + ChatColor.GRAY + "Spieler dreht sich", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_BeyBlade(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            Player vic = Bukkit.getPlayer(args[1]);
            if (!this.players.contains(vic)) {
                this.players.add(vic);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§aSpieler fängt an sich zu drehen!");
            } else {
                this.players.remove(vic);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§cSpieler hat aufgehört sich zu drehen.");
            }
        }
    }

}
