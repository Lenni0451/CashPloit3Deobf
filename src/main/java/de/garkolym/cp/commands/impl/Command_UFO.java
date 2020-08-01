package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class Command_UFO extends CommandBase implements Listener {

    public Location location = null;
    public boolean enabled = false;
    public Player player = null;
    public ArrayList UNUSED_LIST = new ArrayList();
    private final Random rnd = new Random();

    public Command_UFO() {
        super("ufo", "-", Category.WORLD);
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_UFO2(this), 3L, 3L);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void moveUFO(Location lc) {
        ArrayList<FallingBlock> tmp = new ArrayList<>();

        double x;
        double y;
        double z;
        FallingBlock fb;
        for (x = lc.getX() - 2.0D; x <= lc.getX() + 2.0D; ++x) {
            for (y = lc.getY() + 0.0D; y <= lc.getY() + 0.0D; ++y) {
                for (z = lc.getZ() - 2.0D; z <= lc.getZ() + 2.0D; ++z) {
                    if (this.rnd.nextInt(5) == 1) {
                        fb = lc.getWorld().spawnFallingBlock(new Location(lc.getWorld(), x, y, z), Material.WOOL, (byte) 4);
                        tmp.add(fb);
                    } else {
                        fb = lc.getWorld().spawnFallingBlock(new Location(lc.getWorld(), x, y, z), Material.WOOL, (byte) 7);
                        tmp.add(fb);
                    }
                }
            }
        }

        for (x = lc.getX() - 2.0D; x <= lc.getX() + 2.0D; ++x) {
            for (y = lc.getY() + 1.0D; y <= lc.getY() + 1.0D; ++y) {
                for (z = lc.getZ() - 2.0D; z <= lc.getZ() + 2.0D; ++z) {
                    fb = lc.getWorld().spawnFallingBlock(new Location(lc.getWorld(), x, y, z), Material.GLASS, (byte) 0);
                    tmp.add(fb);
                }
            }
        }

        for (x = lc.getX() - 1.0D; x <= lc.getX() + 1.0D; ++x) {
            for (y = lc.getY() + 2.0D; y <= lc.getY() + 2.0D; ++y) {
                for (z = lc.getZ() - 1.0D; z <= lc.getZ() + 1.0D; ++z) {
                    fb = lc.getWorld().spawnFallingBlock(new Location(lc.getWorld(), x, y, z), Material.GLASS, (byte) 0);
                    tmp.add(fb);
                }
            }
        }

        for (Object o : tmp) {
            FallingBlock b = (FallingBlock) o;
            b.remove();
        }

        tmp.clear();
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        try {
            if (this.enabled) {
                Player p = e.getPlayer();
                if (this.player.equals(p)) {
                    e.setCancelled(true);
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        try {
            if (this.enabled) {
                Player p = (Player) e.getWhoClicked();
                if (this.player.equals(p)) {
                    e.setCancelled(true);
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            if (this.enabled) {
                Player p = e.getPlayer();
                if (this.player.equals(p)) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lNACH VORNE")) {
                        this.location.getWorld().playSound(this.location, Sound.NOTE_BASS, 40.0F, 0.1F);
                        this.location.add(1.5D, 0.0D, 0.0D);
                    }

                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lNACH HINTEN")) {
                        this.location.getWorld().playSound(this.location, Sound.NOTE_BASS, 40.0F, 0.1F);
                        this.location.add(-1.5D, 0.0D, 0.0D);
                    }

                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lNACH LINKS")) {
                        this.location.getWorld().playSound(this.location, Sound.NOTE_BASS, 40.0F, 0.1F);
                        this.location.add(0.0D, 0.0D, -1.5D);
                    }

                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lNACH RECHTS")) {
                        this.location.add(0.0D, 0.0D, 1.5D);
                        this.location.getWorld().playSound(this.location, Sound.NOTE_BASS, 40.0F, 0.1F);
                    }

                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lCREEPER")) {
                        for (int i = 0; i < 20; ++i) {
                            this.location.getWorld().spawnEntity(this.location, EntityType.CREEPER);
                        }

                        p.sendMessage(Start.INSTANCE.chatPrefix + "§bPLING!");
                        this.location.getWorld().playSound(this.location, Sound.NOTE_PLING, 40.0F, 1.2F);
                    }

                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lLASERSTRAHL")) {
                        for (double x = this.location.getX() - 2.0D; x <= this.location.getX() + 2.0D; ++x) {
                            for (double y = this.location.getY() - 1.0D; y >= this.location.getY() - 50.0D; --y) {
                                for (double z = this.location.getZ() - 2.0D; z <= this.location.getZ() + 2.0D; ++z) {
                                    Location lc = new Location(this.location.getWorld(), x, y, z);
                                    if (!lc.getBlock().getType().equals(Material.AIR)) {
                                        lc.getBlock().getWorld().createExplosion(lc, 3.0F);
                                    }
                                }
                            }
                        }

                        p.sendMessage(Start.INSTANCE.chatPrefix + "§cPÄÄÄNNGGH!");
                        this.location.getWorld().playSound(this.location, Sound.EXPLODE, 40.0F, 0.2F);
                        this.location.getWorld().playSound(this.location, Sound.FIREWORK_LAUNCH, 40.0F, 0.3F);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void execute(Player p) {
        ItemStack itemVorne = new ItemStack(Material.LEVER);
        ItemMeta metaVorne = itemVorne.getItemMeta();
        metaVorne.setDisplayName("§a§lNACH VORNE");
        itemVorne.setItemMeta(metaVorne);
        ItemStack itemHinten = new ItemStack(Material.LEVER);
        ItemMeta metaHinten = itemVorne.getItemMeta();
        metaHinten.setDisplayName("§b§lNACH HINTEN");
        itemHinten.setItemMeta(metaHinten);
        ItemStack itemLINKS = new ItemStack(Material.LEVER);
        ItemMeta metaLINKS = itemVorne.getItemMeta();
        metaLINKS.setDisplayName("§c§lNACH LINKS");
        itemLINKS.setItemMeta(metaLINKS);
        ItemStack itemRECHTS = new ItemStack(Material.LEVER);
        ItemMeta metaRECHTS = itemVorne.getItemMeta();
        metaRECHTS.setDisplayName("§d§lNACH RECHTS");
        itemRECHTS.setItemMeta(metaRECHTS);
        ItemStack itemBOMBE = new ItemStack(Material.SLIME_BALL);
        ItemMeta metaBOMBE = itemVorne.getItemMeta();
        metaBOMBE.setDisplayName("§c§lLASERSTRAHL");
        itemBOMBE.setItemMeta(metaBOMBE);
        ItemStack itemCREEPER = new ItemStack(Material.ANVIL);
        ItemMeta metaCREEPER = itemCREEPER.getItemMeta();
        metaCREEPER.setDisplayName("§a§lCREEPER");
        itemCREEPER.setItemMeta(metaCREEPER);
        p.getInventory().setItem(0, itemVorne);
        p.getInventory().setItem(1, itemHinten);
        p.getInventory().setItem(2, itemLINKS);
        p.getInventory().setItem(3, itemRECHTS);
        p.getInventory().setItem(4, itemBOMBE);
        p.getInventory().setItem(8, itemCREEPER);
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            this.player = p;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Du hast ein Ufo gespawnt! Kontrolliere es mit den Items!");
            Location lc = p.getLocation();
            this.execute(p);
            lc.setY(lc.getY() + 25.0D);
            this.location = lc;
            this.enabled = true;
        } else {
            this.enabled = false;

            for (int i = 0; i < 9; ++i) {
                p.getInventory().setItem(i, new ItemStack(Material.AIR));
            }
        }
    }

}
