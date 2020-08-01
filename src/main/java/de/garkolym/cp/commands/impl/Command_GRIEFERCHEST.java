package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Command_GRIEFERCHEST extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_GRIEFERCHEST() {
        super("grieferchest", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Jedes Inventar beim Spieler, beinhaltet TNT!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDer Schrecken hat aufgehört!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        if (this.players.contains(e.getPlayer())) {
            for (int i = 0; i < e.getInventory().getSize(); ++i) {
                e.getInventory().setItem(i, new ItemStack(Material.TNT, 64));
            }
        }
    }

}
