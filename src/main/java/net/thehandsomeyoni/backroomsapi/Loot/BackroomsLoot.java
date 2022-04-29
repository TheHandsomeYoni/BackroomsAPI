package net.thehandsomeyoni.backroomsapi.Loot;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static net.thehandsomeyoni.backroomsapi.utils.Constants.color;

public class BackroomsLoot {
    private ItemStack item;
    private ItemMeta meta;

    public BackroomsLoot(Material item, String name, List<String> lore){
        this.item = new ItemStack(item);
        this.meta = this.item.getItemMeta();
        this.meta.setLore(color(lore));
        this.meta.setDisplayName(color(name));
        this.item.setItemMeta(meta);
    }
    public BackroomsLoot(Material item, String name){
        this.item = new ItemStack(item);
        this.meta = this.item.getItemMeta();
        this.meta.setDisplayName(color(name));
        this.item.setItemMeta(meta);
    }

    public BackroomsLoot(ItemStack item){
        this.item = item;
    }
}
