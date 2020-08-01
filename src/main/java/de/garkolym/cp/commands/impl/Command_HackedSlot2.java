package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;

class Command_HackedSlot2 implements Runnable {

    final Command_HackedSlot commandInstance;

    Command_HackedSlot2(Command_HackedSlot var1) {
        this.commandInstance = var1;
    }

    public void run() {
        Object[] var4;
        int var3 = (var4 = Command_HackedSlot.getPlayersFromInstance(this.commandInstance).entrySet().toArray()).length;

        for (int var2 = 0; var2 < var3; ++var2) {
            Object user = var4[var2];
            if (user instanceof Player) {
                ((Player) user).sendMessage("a");
            }
        }
    }

}
