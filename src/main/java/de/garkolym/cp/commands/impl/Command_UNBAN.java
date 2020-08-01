package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;

class Command_UNBAN implements Runnable {

    final Command_UNBAN2 commandInstance;
    private final String[] args;

    Command_UNBAN(Command_UNBAN2 var1, String[] var2) {
        this.commandInstance = var1;
        this.args = var2;
    }

    public void run() {
        Bukkit.getOfflinePlayer(this.args[1]).setBanned(false);
    }

}
