package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Random;

public class Command_HACKED2 extends CommandBase implements Listener {

    public ArrayList<Player> players = new ArrayList<>();
    public Random rnd = new Random();

    public Command_HACKED2() {
        super("hacked", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_HACKED(this), 2L, 2L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler denkt jetzt, dass seine Grafikkarte kapput geht.");
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Der Schock hat aufgehört!");

                    for (int i = 0; i < 100; ++i) {
                        victim.sendMessage("");
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }

}
