package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_FAKEOP extends CommandBase {

    public Command_FAKEOP() {
        super("fakeop", "<Spieler>", Category.TROLLING);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                vic.sendMessage("§7§o" + "[Server: " + vic.getName() + " was opped]");
                p.sendMessage(Start.INSTANCE.chatPrefix + "Spieler denkt, dass er OP hätte :)");
            }
        } catch (Exception var4) {
        }
    }

}
