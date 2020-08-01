package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Command_ENDSCREEN extends CommandBase {

    public Command_ENDSCREEN() {
        super("endscreen", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(4, 0.0F));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Bei ihm erscheint ein End-Screen :D");
            } catch (Exception ignored) {
            }
        }
    }

}
