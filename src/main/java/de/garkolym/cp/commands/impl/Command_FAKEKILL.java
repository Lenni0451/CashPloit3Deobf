package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class Command_FAKEKILL extends CommandBase {

    public Command_FAKEKILL() {
        super("fakekill", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                vic.playEffect(EntityEffect.DEATH);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Der Spieler denkt jetzt, dass er tot ist :D");
            }
        } catch (Exception ignored) {
        }
    }

}
