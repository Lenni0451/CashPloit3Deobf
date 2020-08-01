package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_HARDSTYLER extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_HARDSTYLER() {
        super("hardstyler", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_HARDSTYLER2(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Der Spieler benimmt sich jetzt wie ein Hardstyler!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDer Spieler benimmt sich nicht mehr wie ein Hardstyler.");
                }
            } catch (Exception var4) {
            }
        }

    }

    static ArrayList<Player> getPlayersFromInstance(Command_HARDSTYLER var0) {
        return var0.players;
    }

}
