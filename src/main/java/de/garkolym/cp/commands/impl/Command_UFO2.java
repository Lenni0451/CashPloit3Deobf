package de.garkolym.cp.commands.impl;

class Command_UFO2 implements Runnable {

    final Command_UFO commandInstance;

    Command_UFO2(Command_UFO var1) {
        this.commandInstance = var1;
    }

    public void run() {
        if (this.commandInstance.enabled) {
            this.commandInstance.moveUFO(this.commandInstance.location);
        }
    }

}
