package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;

class Command_KICK2 implements Runnable {

    final Command_KICK commandInstance;
    private final String[] args;

    Command_KICK2(Command_KICK var1, String[] var2) {
        this.commandInstance = var1;
        this.args = var2;
    }

    public void run() {
        Bukkit.getPlayer(this.args[1]).kickPlayer("");
    }

}
