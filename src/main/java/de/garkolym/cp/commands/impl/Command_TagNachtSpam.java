package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_TagNachtSpam extends CommandBase {

    private boolean enabled = false;
    private boolean night = false;
    Player executor = null;

    public Command_TagNachtSpam() {
        super("tagnachtspam", "-", Category.TROLLING);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_TagNachtSpam2(this, null), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 1) {
            this.executor = p;
            if (!this.enabled) {
                this.enabled = true;
                p.sendMessage(Start.INSTANCE.chatPrefix + "TagNachtSpam wurde aktiviert!");
            } else {
                this.enabled = false;
                p.sendMessage(Start.INSTANCE.chatPrefix + "TagNachtSpam wurde deaktiviert.");
            }
        }

    }

    static boolean isEnabledFromInstance(Command_TagNachtSpam var0) {
        return var0.enabled;
    }

    static boolean setNightOfInstance(Command_TagNachtSpam var0) {
        return var0.night;
    }

    static void isNightFromInstance(Command_TagNachtSpam var0, boolean var1) {
        var0.night = var1;
    }

}
