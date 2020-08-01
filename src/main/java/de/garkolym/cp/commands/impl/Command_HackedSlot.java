package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Command_HackedSlot extends CommandBase {

    private final HashMap<Player, Integer> players = new HashMap<>();

    public Command_HackedSlot() {
        super("hackedslots", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_HackedSlot2(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (!this.players.containsKey(p)) {
                this.players.put(p, p.getInventory().getHeldItemSlot());
            } else {
                this.players.remove(p);
            }
        } catch (Exception ignored) {
        }

    }

    static HashMap<Player, Integer> getPlayersFromInstance(Command_HackedSlot var0) {
        return var0.players;
    }

}
