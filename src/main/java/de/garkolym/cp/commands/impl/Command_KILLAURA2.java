package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_KILLAURA2 extends CommandBase {

    public ArrayList<Player> players = new ArrayList<>();

    public Command_KILLAURA2() {
        super("killaura", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_KILLAURA(this), 5L, 5L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            if (!this.players.contains(p)) {
                this.players.add(p);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§aJetzt denkt jeder Owner, dass dieser Spieler, KillAura hat :)!");
            } else {
                this.players.remove(p);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§cDie Fake-KillAura wurde bei dem Spieler deaktiviert.");
            }
        }
    }

}
