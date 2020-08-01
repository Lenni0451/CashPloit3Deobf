package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Command_TNTINVASION extends CommandBase implements Listener {

    private boolean enabled = false;

    public Command_TNTINVASION() {
        super("tntinvasion", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            for (Entity en : p.getWorld().getEntities()) {
                if (!(en instanceof Player)) {
                    en.remove();
                }
            }

            this.enabled = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt müsste überall TNT rumfliegen!");
        } else {
            this.enabled = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cDas fliegende TNT ist weg.");
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        if (this.enabled) {
            if (!(e.getEntity() instanceof Bat) && !(e.getEntity() instanceof Minecart)) {
                e.setCancelled(true);
                Bat bat = (Bat) e.getLocation().getWorld().spawnEntity(e.getLocation(), EntityType.BAT);
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 5));
            } else {
                FallingBlock fb = e.getLocation().getWorld().spawnFallingBlock(e.getLocation(), 46, (byte) 0);
                e.getEntity().setPassenger(fb);
            }
        }
    }

}
