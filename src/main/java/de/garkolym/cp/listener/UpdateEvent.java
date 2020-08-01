package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.CommandBase;

import java.util.Iterator;

public class UpdateEvent implements Runnable {
    public void run() {
        Iterator var2 = Start.INSTANCE.commandManager.commands.iterator();

        while (var2.hasNext()) {
            CommandBase m = (CommandBase) var2.next();
            m.onTick();
        }

    }
}
