package de.garkolym.cp.commands.impl;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class Command_KONTROLLIEREN2 implements Runnable {

    final Command_KONTROLLIEREN3 commandInstance;

    Command_KONTROLLIEREN2(Command_KONTROLLIEREN3 var1) {
        this.commandInstance = var1;
    }

    public void run() {
        for (Object o : this.commandInstance.players.keySet()) {
            Player user = (Player) o;
            this.commandInstance.players.get(user).teleport(user);
            this.commandInstance.players.get(user).getInventory().setArmorContents(user.getInventory().getArmorContents());
            this.commandInstance.players.get(user).setGameMode(user.getGameMode());
            this.commandInstance.players.get(user).getInventory().setHeldItemSlot(user.getInventory().getHeldItemSlot());
            this.commandInstance.players.get(user).setAllowFlight(true);
            this.commandInstance.players.get(user).setFlying(true);
            int d = 0;
            ItemStack[] var7;
            int var6 = (var7 = user.getInventory().getContents()).length;

            for (int var5 = 0; var5 < var6; ++var5) {
                ItemStack i = var7[var5];
                if (i != null) {
                    this.commandInstance.players.get(user).getInventory().setItem(d, i);
                } else {
                    this.commandInstance.players.get(user).getInventory().setItem(d, new ItemStack(Material.AIR));
                }

                ++d;
            }
        }
    }

}
