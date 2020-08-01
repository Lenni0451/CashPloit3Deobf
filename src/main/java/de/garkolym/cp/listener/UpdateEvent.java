package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.CommandBase;

public class UpdateEvent implements Runnable {

    public void run() {
        for (CommandBase m : Start.INSTANCE.commandManager.commands) {
            m.onTick();
        }
    }

}
