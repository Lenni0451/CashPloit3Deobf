package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.ArrayList;

public class Command_InvBlock extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_InvBlock() {
        super("invblock", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Sein Inventar wurde komplett blockiert!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cSein Inventar ist nicht mehr geblockt!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            if (this.players.contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            if (this.players.contains(p)) {
                e.setCancelled(true);
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        try {
            if (this.players.contains(e.getPlayer())) {
                e.setCancelled(true);
            }
        } catch (Exception ignored) {
        }
    }

}
