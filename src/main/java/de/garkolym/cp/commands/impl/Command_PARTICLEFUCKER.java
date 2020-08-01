package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_PARTICLEFUCKER extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_PARTICLEFUCKER() {
        super("particlefucker", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_PARTICLEFUCKER2(this), 10L, 10L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler bekommt jetzt die ganze Zeit Partikeln!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cSpieler bekommt keine Partikeln mehr.");
                }
            }
        } catch (Exception ignored) {
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_PARTICLEFUCKER var0) {
        return var0.players;
    }

}
