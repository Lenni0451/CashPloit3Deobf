package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_WEBTROLL extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_WEBTROLL() {
        super("webtroll", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_WEBTROLL2(this), 40L, 40L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                } else {
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt ist beim Spieler wieder alles normal.");
                    this.players.remove(victim);
                }
            } catch (Exception ignored) {
            }
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_WEBTROLL var0) {
        return var0.players;
    }

}
