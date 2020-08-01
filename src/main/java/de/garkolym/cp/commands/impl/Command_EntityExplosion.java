package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class Command_EntityExplosion extends CommandBase implements Listener {

    private boolean explode = false;

    public Command_EntityExplosion() {
        super("entityexplosion", "-", Category.WORLD);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.explode) {
            this.explode = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Jedes geschlagene Entity explodiert!");
        } else {
            this.explode = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cDie Entitys explodieren nicht mehr.");
        }

    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent e) {
        if (this.explode) {
            try {
                e.getRightClicked().getWorld().createExplosion(e.getRightClicked().getLocation(), 3.0F);
            } catch (Exception ignored) {
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (this.explode) {
            try {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 3.0F);
            } catch (Exception ignored) {
            }
        }
    }

}
