package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;

public class Command_DAMAGE extends CommandBase {

    public Command_DAMAGE() {
        super("damage", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                vic.playEffect(EntityEffect.HURT);
                p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler bekommt nun Damage.");
            }
        } catch (Exception ignored) {
        }
    }

}
