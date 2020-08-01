package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_SoundSpam2 extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_SoundSpam2() {
        super("soundspam", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_SoundSpam(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler wird von Tönen belästigt!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDas ganze hat beim Spieler jetzt aufgehört!");
                }
            }
        } catch (Exception ignored) {
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_SoundSpam2 var0) {
        return var0.players;
    }

}
