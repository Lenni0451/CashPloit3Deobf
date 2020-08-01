package de.garkolym.cp.commands.impl;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

class Command_HACKED implements Runnable {

    public int state;
    final Command_HACKED2 commandInstance;

    Command_HACKED(Command_HACKED2 var1) {
        this.commandInstance = var1;
        this.state = 1;
    }

    public void run() {
        for (Player user : this.commandInstance.players) {
            try {
                ((CraftPlayer) user).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(7, (float) this.state));
            } catch (Exception ignored) {
            }

            for (int i = 0; i < 40; ++i) {
                user.sendMessage("");
            }

            user.playSound(user.getLocation(), Sound.ANVIL_BREAK, 100.0F, 100.0F);
            user.playSound(user.getLocation(), Sound.BAT_DEATH, 100.0F, 100.0F);
            user.playSound(user.getLocation(), Sound.CAT_MEOW, 100.0F, 100.0F);
            user.sendMessage(ChatColor.LIGHT_PURPLE + "         |||||||         ");
            user.sendMessage(ChatColor.LIGHT_PURPLE + "      ==||O|||O||==      " + ChatColor.GREEN + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100));
            user.sendMessage(ChatColor.LIGHT_PURPLE + "      ==|||___|||==      " + ChatColor.GREEN + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100) + this.commandInstance.rnd.nextInt(100));
            user.sendMessage(ChatColor.LIGHT_PURPLE + "        |||||||||        ");
            user.sendMessage("");
            if (this.state == 1) {
                user.sendMessage("§cDein Mojang Passwort wird geändert, Bitte warten ...§a");
            } else if (this.state == 2) {
                user.sendMessage("§cDein Mojang Passwort wird geändert, Bitte warten ..§a");
            } else if (this.state == 3) {
                user.sendMessage("§cDein Mojang Passwort wird geändert, Bitte warten .§a");
            } else {
                user.sendMessage("§cDein Mojang Passwort wird geändert, Bitte warten§a");
            }

            user.closeInventory();
            user.openInventory(Bukkit.createInventory(null, 27));
            ((CraftPlayer) user).getHandle().playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 0.0F));
        }

        ++this.state;
        if (this.state > 50) {
            this.state = 1;
        }
    }

}
