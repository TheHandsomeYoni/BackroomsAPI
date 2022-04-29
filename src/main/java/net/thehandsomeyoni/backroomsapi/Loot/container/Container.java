package net.thehandsomeyoni.backroomsapi.Loot.container;

import com.sun.tools.javac.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * This class is used to store items/loot that can be found in chests
 */
public class Container {
    private List<ItemStack> itemsList;
    private HashMap<Integer, ItemStack> defaultItems = new HashMap<>();
    private Location location;
    private Block block;
    private Chest chest;
    private boolean isSpawned;
    private boolean isEmpty;

    /**
     * Initializes a new container with the given location and items
     * @param location The location where the new container will form
     * @param items A list of items that will be contained in the container
     */
    public Container (Location location, List<ItemStack> items){
        this.itemsList = items;
        this.location = location;
    }

    /**
     * Initializes a new container with the given location and items
     * @param location The location where the new container will form
     * @param items An array of items that will be contained in the container
     */
    public Container (Location location, ItemStack[] items){
        this.location = location;
        for(ItemStack item : items){
            this.itemsList.add(item);
        }
    }
    /**
     * Initializes a new container with the given location
     * @param location The location where the new container will form
     */
    public Container (Location location){
        this.location = location;
    }

    /**
     * Spawns the new container
     */
    public void spawn(){
        block = this.location.getBlock();
        block.setType(Material.CHEST);
        chest = (Chest) block.getState();
        chest.getBlockInventory().setContents(this.itemsList.toArray(new ItemStack[0]));

        for(int i : this.defaultItems.keySet()){
            chest.getBlockInventory().setItem(i, this.defaultItems.get(i));
        }
        this.isSpawned = true;
    }

    /**
     * Adds an item that initially will be in the container in addition to the already specified items
     * @param item An item to be added to the container
     */
    public void addDefaultItem(ItemStack item){
        this.itemsList.add(item);
    }
    /**
     * Adds an item that initially will be in the container in EXACT slot (and not in the first empty) in addition to the items that were already specified
     * @param item An item to be added to the container
     */
    public void addDefaultItemExact(int slot, ItemStack item){
        this.defaultItems.put(slot, item);
    }

    /**
     * Adds items that will initially be added to the container in addition to the items that were already specified
     * @param items An array of items that will be added
     */
    public void addDefaultItems(ItemStack[] items){
        for (ItemStack item : items){
            this.itemsList.add(item);
        }
    }

    /**
     * Adds items that will initially be added to the container in addition to the items that were already specified
     * @param items A list of items that will be added
     */
    public void addDefaultItems(List<ItemStack> items){
        items.forEach(item -> {
            this.itemsList.add(item);
        });
    }

    /**
     * Adds an item to the container AFTER IT SPAWNS in addition to the items that were already spawned
     * @param slot The slot where the item will be added
     * @param item The item that will be added
     */
    public void addItem(int slot, ItemStack item){
        if(this.isSpawned){
            this.chest.getBlockInventory().setItem(slot, item);
        }
    }

    /**
     * Adds items to the container AFTER IT SPAWNS in addition to the items that were already spawned
     * @param items An array of items that will be spawned in the container
     */
    public void addItems(ItemStack[] items){
        if(this.isSpawned){
            this.chest.getBlockInventory().setContents(items);
        }
    }

    /**
     * Adds items to the container AFTER IT SPAWNS in addition to the items that were already spawned
     * @param items A list of items that will be spawned in the container
     */
    public void addItems(List<ItemStack> items){
        if(isSpawned){
            this.chest.getBlockInventory().setContents(items.toArray(new ItemStack[0]));
        }
    }

    /**
     * Removes a container from its current position
     */
    public void remove(){
        this.block.breakNaturally();
    }
}
