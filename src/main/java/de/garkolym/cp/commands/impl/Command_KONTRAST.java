package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Command_KONTRAST extends CommandBase {

    public Command_KONTRAST() {
        super("kontrast", "<Spieler> <id>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 3) {
            try {
                Player victim = Bukkit.getPlayer(args[1]);
                int ID = Integer.parseInt(args[2]);
                boolean ausgabe = true;
                switch (ID) {
                    case 1:
                        ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 12.0F));
                        break;
                    case 2:
                        ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 30.0F));
                        break;
                    case 3:
                        ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 40000.0F));
                        break;
                    case 4:
                        ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 20000.0F));
                        break;
                    case 5:
                        ((CraftPlayer) victim).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, 19500.0F));
                        break;
                    default:
                        ausgabe = false;
                        this.execute(p);
                }

                if (!ausgabe) {
                    return;
                }

                p.sendMessage(Start.INSTANCE.chatPrefix + "Der Kontrast beim Spieler hat sich jetzt geändert! :D");
            } catch (Exception ignored) {
            }
        } else {
            this.execute(p);
        }

    }

    private void execute(Player p) {
        p.sendMessage(Start.INSTANCE.chatPrefix + "§cUsage: +kontrast <Spieler> <id>");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§aids:");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§b<1> Himmel = Dunkelblau");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§b<2> Himmel = Hellblau");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§b<3> Blöcke = Rot");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§b<4> Blöcke = Rot & Grün");
        p.sendMessage(Start.INSTANCE.chatPrefix + "§b<5> Verpixelte Texturen");
    }

}
