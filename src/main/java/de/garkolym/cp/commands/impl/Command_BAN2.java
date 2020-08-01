package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;

class Command_BAN2 implements Runnable {

    final Command_BAN commandInstance;
    private final String[] args;

    Command_BAN2(Command_BAN var1, String[] var2) {
        this.commandInstance = var1;
        this.args = var2;
    }

    public void run() {
        Bukkit.getPlayer(this.args[1]).kickPlayer("");
        Bukkit.getPlayer(this.args[1]).setBanned(true);
    }

}
