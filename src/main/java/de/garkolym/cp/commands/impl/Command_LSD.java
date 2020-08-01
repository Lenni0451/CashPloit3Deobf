package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_LSD extends CommandBase {

    private boolean colorState = true;
    private final ArrayList<Player> players = new ArrayList<>();

    public Command_LSD() {
        super("LSD", "<Spieler>", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_LSD2(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt ist dieser Spieler im Rausch!");
                } else {
                    this.players.remove(vic);
                    ((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 0.0F));
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler ist nicht mehr im Rausch.");
                }
            }
        } catch (Exception ignored) {
        }

    }

    static boolean getColorStateFromInstance(Command_LSD var0) {
        return var0.colorState;
    }

    static ArrayList<Player> getPlayersFromInstance(Command_LSD var0) {
        return var0.players;
    }

    static void setColorStateOfInstance(Command_LSD var0, boolean var1) {
        var0.colorState = var1;
    }

}
