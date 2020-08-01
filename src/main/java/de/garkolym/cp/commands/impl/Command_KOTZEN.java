package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Command_KOTZEN extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_KOTZEN() {
        super("kotzen", "<Spieler>", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler kotzt nun beim laufen!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cSpieler kotzt nicht mehr beim laufen.");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (this.players.contains(e.getPlayer())) {
            FallingBlock b1 = e.getPlayer().getWorld().spawnFallingBlock(e.getPlayer().getEyeLocation(), Material.WOOL, (byte) 4);
            FallingBlock b2 = e.getPlayer().getWorld().spawnFallingBlock(e.getPlayer().getEyeLocation(), Material.WOOL, (byte) 5);
            b1.setVelocity(e.getPlayer().getLocation().getDirection().multiply(2.3D));
            b2.setVelocity(e.getPlayer().getLocation().getDirection().multiply(2.3D));
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.COW_HURT, 0.8F, 0.8F);
        }
    }

}
