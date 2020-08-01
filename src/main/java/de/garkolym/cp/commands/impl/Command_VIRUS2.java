package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Command_VIRUS2 extends CommandBase {

    private final HashMap<Player, Integer> players = new HashMap<>();

    public Command_VIRUS2() {
        super("virus", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_VIRUS(this), 2L, 2L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.containsKey(victim)) {
                    this.players.put(victim, 0);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt hat dieser Spieler einen Virus-Screen :D");
                } else {
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler erscheint bereits der Virus-Screen!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    static HashMap<Player, Integer> getPlayersFromInstance(Command_VIRUS2 var0) {
        return var0.players;
    }

}
