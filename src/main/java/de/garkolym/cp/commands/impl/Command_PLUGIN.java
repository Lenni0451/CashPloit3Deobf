package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Command_PLUGIN extends CommandBase {

    public Command_PLUGIN() {
        super("plugins", "-", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            String list = "§e";
            Plugin[] var7;
            int var6 = (var7 = Bukkit.getPluginManager().getPlugins()).length;

            for (int var5 = 0; var5 < var6; ++var5) {
                Plugin pl = var7[var5];
                list = list + pl.getName() + ", ";
            }

            p.sendMessage(Start.INSTANCE.chatPrefix + "Plugins: ");
            p.sendMessage(Start.INSTANCE.chatPrefix + list);
        } catch (Exception ignored) {
        }
    }

}
