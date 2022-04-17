package net.thehandsomeyoni.backrooms.abstracts;

import net.thehandsomeyoni.backrooms.Enums.EntityThreatClassification;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.net.URL;

public abstract class BackroomsEntity  {
    protected NPC npc;

    /**
     * Initializes a new NPC with the given information.
     * The npc is a protected variable.
     */
    public BackroomsEntity(EntityType type, String name) {
        this.npc = CitizensAPI.getNPCRegistry().createNPC(type, name);
    }

    /**
     * Gets the NPC from name
     * @return The npc with the associated name
     */
    public abstract NPC getNPC();

    /**
     * Sets the threat class of the Entity
     */
    public abstract void setThreatClass(EntityThreatClassification threatClass);

    /**
     * Checks the classification level of the entity.
     * @return the entity's class
     */
    public abstract EntityThreatClassification getEntityThreatClass();

    /**
     * Spawns the entity at the specified location
     * @param location The location where the NPC is going to be spawned
     */
    public abstract void spawn(Location location);

    /**
     * Despawns entity from the world.
     * That means the entity will still exist.
     */
    public abstract void despawn();

    /**
     * Sets the movement speed of the entity.
     * The speed can be set between 1-10, as 1 is the slowest and 10 is the fastest.
     * @param speed the speed of the entity in numbers
     */
    public abstract void setEntitySpeed(int speed);

    /**
     * Sets the ability of the entity to fly.
     * @param allow allows the entity to fly.
     */
    public abstract void setFlying(boolean allow);

    /**
     * Checks if the entity can fly
     * @return 'true' if it can fly, and 'false' if it can't
     */
    public abstract boolean isFlying();

    /**
     * Sets if the entity will behave like minecraft's AI
     * @param use Applies minecraft's AI on the entity
     */
    public abstract void useMinecraftAI(boolean use);

    /***
     * Gives the NPC a skin to your choice from a player.
     * @param name The name of the player that his skin will be used
     */
    public abstract void setSkin(String name);

    /**
     * Gives the NPC a skin to your choice from an url. Note: the url should finnish with .png to make sure an image is being taken
     * @param url The url where the skin is going to be taken from.
     */
    public abstract void setSkin(URL url);
}
