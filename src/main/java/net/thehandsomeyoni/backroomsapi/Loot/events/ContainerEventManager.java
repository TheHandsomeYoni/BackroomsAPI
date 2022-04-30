package net.thehandsomeyoni.backroomsapi.Loot.events;

import net.thehandsomeyoni.backroomsapi.Loot.container.Container;
import org.bukkit.Bukkit;

public final class ContainerEventManager {

    public static void callEvent(Container container){
        Bukkit.getPluginManager().callEvent(new ClearContainerEvent(container));
    }
}
