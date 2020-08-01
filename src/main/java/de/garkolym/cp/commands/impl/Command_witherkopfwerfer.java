package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_witherkopfwerfer extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_witherkopfwerfer() {
        super("witherkopfwerfer", "<Spieler>", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_witherkopfwerfer2(this), 15L, 15L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler wirft nun mit WitherKöpfen!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cSpieler wirft nicht mehr mit WitherKöpfen!");
                }
            }
        } catch (Exception ignored) {
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_witherkopfwerfer var0) {
        return var0.players;
    }

}
