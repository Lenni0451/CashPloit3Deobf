package de.garkolym.cp.commands;

import org.bukkit.entity.Player;

public class CommandBase {

    private String name;
    private String description;
    private final Category category;

    public CommandBase(String Befehl, String Beschreibung, Category bereich) {
        this.name = Befehl;
        this.description = Beschreibung;
        this.category = bereich;
    }

    public void setName(String Content) {
        this.name = Content;
    }

    public void setDescription(String Content) {
        this.description = Content;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void execute(String[] args, Player p) {
    }

    public void onTick() {
    }

}
