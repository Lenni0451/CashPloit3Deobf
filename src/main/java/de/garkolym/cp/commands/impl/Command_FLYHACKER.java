package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class Command_FLYHACKER extends CommandBase implements Listener {

    private final ArrayList<Player> players = new ArrayList<>();

    public Command_FLYHACKER() {
        super("flyhacker", "<player> FLYHACKERBLABLABLA", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(victim)) {
                    this.players.add(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Er ist jetzt ein FlyHacker!");
                } else {
                    this.players.remove(victim);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Er ist kein FlyHacker mehr!");
                }
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        for (Object player : this.players) {
            Player user = (Player) player;
            user.setVelocity(user.getLocation().getDirection());
        }
    }

}
