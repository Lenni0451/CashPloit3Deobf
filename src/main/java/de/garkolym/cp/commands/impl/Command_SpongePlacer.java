package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class Command_SpongePlacer extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_SpongePlacer() {
        super("spongeplacer", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler plaziert jetzt nurnoch Sponge!");
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler plaziert keinen Sponge mehr.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (this.players.contains(e.getPlayer())) {
            e.getBlock().setType(Material.SPONGE);
        }
    }

}
