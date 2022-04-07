package org.kcsup.skywars;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.kcsup.skywars.arena.Arena;
import org.kcsup.skywars.arena.ArenaManager;
import org.kcsup.skywars.arena.sign.SignManager;
import org.kcsup.skywars.commands.CustomCommand;
import org.kcsup.skywars.commands.executors.ArenaCommand;
import org.kcsup.skywars.game.GameListener;

public final class Main extends JavaPlugin {
    private ArenaManager arenaManager;
    private SignManager signManager;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        signManager = new SignManager(this);
        arenaManager = new ArenaManager(this);

        arenaManager.initiateArenas();
        signManager.reloadAllSigns();

        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        CustomCommand arenaCommand = new CustomCommand(getConfig().getString("command-name"), getConfig().getStringList("command-aliases"));
        arenaCommand.setExecutor(new ArenaCommand(this));
    }

    public ArenaManager getArenaManager() { return arenaManager; }

    public SignManager getSignManager() {
        return signManager;
    }

    @Override
    public void onDisable() {
        for(Arena arena : arenaManager.getArenas()) arena.reset();
    }
}
