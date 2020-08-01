package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

class Command_GriefHacke3 implements Runnable {

    final Command_GriefHacke commandInstance;
    private final Player player;

    Command_GriefHacke3(Command_GriefHacke var1, Player var2) {
        this.commandInstance = var1;
        this.player = var2;
    }

    public void run() {
        ArmorStand Spitzhacke = (ArmorStand) this.player.getWorld().spawnEntity(this.player.getLocation(), EntityType.ARMOR_STAND);
        Spitzhacke.setGravity(false);
        Spitzhacke.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
        Spitzhacke.setVisible(false);
        Spitzhacke.setMarker(true);
        this.commandInstance.pickaxes.add(Spitzhacke);
        this.player.sendMessage(Start.INSTANCE.chatPrefix + "Eine Griefer-Spitz-Hacke wurde gespawnt!");
    }

}
