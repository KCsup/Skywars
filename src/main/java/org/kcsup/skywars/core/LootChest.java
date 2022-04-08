package org.kcsup.skywars.core;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootChest {

    private Location location;
    private Chest chest;
    private LootChestType type;

    public LootChest(Location location, LootChestType type) {
        this.location = location;
        this.type = type;

        if(location.getBlock().getType().equals(Material.CHEST)) chest = (Chest) location.getBlock();
    }

    public void fillChest(List<ItemStack> items) {
        if(chest == null) return;

        Inventory inventory = chest.getBlockInventory();
        Random random = new Random();

        for(ItemStack i : items) {
            int slot = random.nextInt(inventory.getSize());
            while(inventory.getItem(slot) != null) slot = random.nextInt(inventory.getSize());
            inventory.setItem(random.nextInt(inventory.getSize()), i);
        }
    }

}
