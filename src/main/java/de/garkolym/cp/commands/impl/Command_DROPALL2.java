package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class Command_DROPALL2 implements Runnable {

    final Command_DROPALL commandInstance;
    private final String[] args;
    private final Player player;

    Command_DROPALL2(Command_DROPALL var1, String[] var2, Player var3) {
        this.commandInstance = var1;
        this.args = var2;
        this.player = var3;
    }

    public void run() {
        try {
            Player victim = Bukkit.getPlayer(this.args[1]);
            ItemStack[] var5;
            int var4 = (var5 = victim.getInventory().getContents()).length;

            for (int var3 = 0; var3 < var4; ++var3) {
                ItemStack i = var5[var3];
                if (i != null) {
                    victim.getWorld().dropItemNaturally(victim.getLocation(), i);
                    victim.getInventory().remove(i);
                }
            }

            this.player.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler hat nun seine ganzen Sachen gedroppt!");
        } catch (Exception ignored) {
        }
    }

}
