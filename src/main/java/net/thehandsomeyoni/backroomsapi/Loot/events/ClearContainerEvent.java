package net.thehandsomeyoni.backroomsapi.Loot.events;

import com.sun.tools.javac.util.List;
import net.thehandsomeyoni.backroomsapi.Loot.container.Container;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ClearContainerEvent extends Event {
    private HandlerList handlers = new HandlerList();
    private Container container;

    public ClearContainerEvent(Container container){
        this.container = container;
    }

    public void removeContainer(){
            getContainer().remove();
    }

    public Container getContainer(){
        return container;
    }

    public void refillContainer(ItemStack[] items){
        container.addItems(items);
    }

    public void refillContainer(List<ItemStack> items){
        container.addItems(items);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
