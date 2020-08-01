package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;

class Command_KILL2 implements Runnable {

    final Command_KILL commandInstance;
    private final String[] args;

    Command_KILL2(Command_KILL var1, String[] var2) {
        this.commandInstance = var1;
        this.args = var2;
    }

    public void run() {
        Bukkit.getPlayer(this.args[1]).setHealth(0.0D);
    }

}
