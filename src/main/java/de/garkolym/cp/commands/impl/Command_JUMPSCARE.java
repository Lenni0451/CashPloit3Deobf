package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Command_JUMPSCARE extends CommandBase {

    public Command_JUMPSCARE() {
        super("jumpscare", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(10, 0.0F));

                for (int i = 0; i < 10; ++i) {
                    vic.playSound(vic.getLocation(), Sound.BAT_DEATH, 2.14748365E9F, 0.2F);
                    vic.playSound(vic.getLocation(), Sound.ANVIL_LAND, 2.14748365E9F, 0.2F);
                    vic.playSound(vic.getLocation(), Sound.ARROW_HIT, 2.14748365E9F, 0.2F);
                    vic.playSound(vic.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 0.2F);
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler hat sich erschrocken!");
            }
        } catch (Exception ignored) {
        }
    }

}
