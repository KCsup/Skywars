package org.kcsup.skywars.core;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class Island {

    private Player player;
    private Location spawn;
    private List<LootChest> chests;

    public Island(Player player, Location spawn, List<LootChest> chests) {
        this.player = player;
        this.spawn = spawn;
        this.chests = chests;
    }



}
