package de.garkolym.cp.commands.impl;

class Command_TagNachtSpam2 implements Runnable {

    final Command_TagNachtSpam commandInstance;

    private Command_TagNachtSpam2(Command_TagNachtSpam var1) {
        this.commandInstance = var1;
    }

    public void run() {
        if (Command_TagNachtSpam.isEnabledFromInstance(this.commandInstance) && this.commandInstance.executor != null) {
            if (Command_TagNachtSpam.setNightOfInstance(this.commandInstance)) {
                this.commandInstance.executor.getWorld().setTime(14000L);
                Command_TagNachtSpam.isNightFromInstance(this.commandInstance, false);
            } else {
                this.commandInstance.executor.getWorld().setTime(0L);
                Command_TagNachtSpam.isNightFromInstance(this.commandInstance, true);
            }
        }

    }

    Command_TagNachtSpam2(Command_TagNachtSpam var1, Command_TagNachtSpam2 var2) {
        this(var1);
    }

}
