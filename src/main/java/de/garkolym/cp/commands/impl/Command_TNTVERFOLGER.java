package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Command_TNTVERFOLGER extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_TNTVERFOLGER() {
        super("tntverfolger", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_TNTVERFOLGER2(this), 120L, 120L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler wird nun vom TNT verfolgt!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cSpieler wird nicht mehr vom TNT verfolgt.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_TNTVERFOLGER var0) {
        return var0.players;
    }

}
