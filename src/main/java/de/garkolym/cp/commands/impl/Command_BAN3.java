package de.garkolym.cp.commands.impl;

import org.bukkit.Bukkit;

class Command_BAN3 implements Runnable {

    final Command_BAN commandInstance;
    private final String[] args;

    Command_BAN3(Command_BAN var1, String[] var2) {
        this.commandInstance = var1;
        this.args = var2;
    }

    public void run() {
        try {
            String grund = "";

            for (int i = 2; i < this.args.length; ++i) {
                grund = grund + this.args[i].replace("&", "§") + " ";
            }

            Bukkit.getPlayer(this.args[1]).kickPlayer(grund);
            Bukkit.getPlayer(this.args[1]).setBanned(true);
        } catch (Exception ignored) {
        }
    }

}
