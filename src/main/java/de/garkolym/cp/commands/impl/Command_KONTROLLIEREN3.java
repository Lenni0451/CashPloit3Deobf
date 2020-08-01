package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class Command_KONTROLLIEREN3 extends CommandBase implements Listener {

    public HashMap<Player, Player> players = new HashMap<>();

    public Command_KONTROLLIEREN3() {
        super("kontrollieren", "<Spieler>", Category.OTHER);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_KONTROLLIEREN2(this), 1L, 1L);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (this.players.containsKey(e.getPlayer()) && (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))) {
            ((CraftPlayer) this.players.get(e.getPlayer())).getHandle().playerConnection.sendPacket(new PacketPlayOutAnimation());
        }

    }

    public void execute(String[] args, Player p) {
        Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_KONTROLLIEREN(this, args, p));
    }

}
