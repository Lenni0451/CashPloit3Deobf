package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_GriefHacke extends CommandBase {

    ArrayList<ArmorStand> pickaxes = new ArrayList<>();

    public Command_GriefHacke() {
        super("grieferhacke", "-", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_GriefHacke2(this), 2L, 2L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                if (args[1].equalsIgnoreCase("clear")) {
                    for (Object pickaxe : this.pickaxes) {
                        ArmorStand ar = (ArmorStand) pickaxe;
                        ar.remove();
                    }

                    this.pickaxes.clear();
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Die Spitzhacken wurden entfernt!");
                }

                if (args[1].equalsIgnoreCase("add")) {
                    Bukkit.getScheduler().runTask(Start.INSTANCE, new Command_GriefHacke3(this, p));
                }
            }
        } catch (Exception ignored) {
        }
    }

}
