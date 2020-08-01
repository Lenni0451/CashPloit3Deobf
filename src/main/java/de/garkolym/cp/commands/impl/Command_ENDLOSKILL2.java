package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_ENDLOSKILL2 extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_ENDLOSKILL2() {
        super("endloskill", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_ENDLOSKILL(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler wird nun dauernd gekillt!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDer Prozess hat aufgehört.");
                }
            }
        } catch (Exception ignored) {
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_ENDLOSKILL2 var0) {
        return var0.players;
    }

}
