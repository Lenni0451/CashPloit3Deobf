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

import java.util.HashMap;
import java.util.HashSet;

public class Command_BrushCube extends CommandBase implements Listener {

    private final HashMap<Player, Material> brushes = new HashMap<>();

    public Command_BrushCube() {
        super("brushcube", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (args.length == 2) {
            try {
                Material m = Material.getMaterial(Integer.parseInt(args[1]));
                this.brushes.put(p, m);
                ItemStack BrushStick = new ItemStack(Material.CARROT_ITEM);
                ItemMeta meta = BrushStick.getItemMeta();
                meta.setDisplayName("§b§lCubeBrusher");
                BrushStick.setItemMeta(meta);
                p.setItemInHand(BrushStick);
                p.sendMessage(Start.INSTANCE.chatPrefix + "§aJetzt kannst du damit brushen!");
            } catch (Exception ignored) {
            }
        }

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            Player p = e.getPlayer();
            if (Start.INSTANCE.trustedPlayers.contains(p.getName()) && this.brushes.containsKey(p) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lCubeBrusher")) {
                Location lc = p.getTargetBlock((HashSet<Byte>) null, 200).getLocation();

                for (double x = lc.getX() - 8.0D; x <= lc.getX() + 8.0D; ++x) {
                    for (double y = lc.getY() - 8.0D; y <= lc.getY() + 8.0D; ++y) {
                        for (double z = lc.getZ() - 8.0D; z <= lc.getZ() + 8.0D; ++z) {
                            (new Location(lc.getWorld(), x, y, z)).getBlock().setType(this.brushes.get(p));
                        }
                    }
                }

                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 2.0F, 2.0F);
            }
        } catch (Exception ignored) {
        }
    }

}
