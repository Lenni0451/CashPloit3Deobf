package de.garkolym.cp.commands.impl;

class Command_LogSpammer2 implements Runnable {

    final Command_LogSpammer commandInstance;

    Command_LogSpammer2(Command_LogSpammer var1) {
        this.commandInstance = var1;
    }

    public void run() {
        if (Command_LogSpammer.isEnabledFromInstance(this.commandInstance)) {
            int bla = Integer.parseInt("Hurensohn");
            System.out.println(bla);
        }
    }

}
