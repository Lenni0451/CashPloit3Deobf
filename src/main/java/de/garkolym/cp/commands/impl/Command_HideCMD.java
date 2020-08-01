package de.garkolym.cp.commands.impl;

import org.bukkit.entity.Player;

class Command_HideCMD implements Runnable {

    final Command_HideCMD2 commandInstance;
    private final String[] args;
    private final Player player;

    Command_HideCMD(Command_HideCMD2 var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            String CMD = "";

            for (int i = 1; i < this.args.length; ++i) {
                CMD = CMD + this.args[i] + " ";
            }

            this.player.performCommand(CMD);
        } catch (Exception ignored) {
        }
    }

}
