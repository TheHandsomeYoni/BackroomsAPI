package net.thehandsomeyoni.backroomsapi.entities;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.TargetType;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.MemoryDataKey;
import net.citizensnpcs.trait.SkinTrait;
import net.thehandsomeyoni.backroomsapi.entities.Enums.EntityThreatClassification;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BackroomsEntity {
    private NPC npc;
    private EntityThreatClassification threatClass;

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
    public NPC getNPC(){
        return this.npc;
    }

    /**
     * Sets the threat class of the Entity
     */
    public void setThreatClass(EntityThreatClassification threatClass){
        this.threatClass = threatClass;
        this.npc.data().setPersistent("threatClass", this.threatClass);
    }

    /**
     * Checks the classification level of the entity.
     * @return the entity's class
     */
    public EntityThreatClassification getEntityThreatClass(){
        try{return EntityThreatClassification.valueOf(this.npc.data().get("threatClass"));
        }catch(NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Spawns the entity at the specified location
     * @param location The location where the NPC is going to be spawned
     */
    public void spawn(Location location){
        this.npc.spawn(location);
    }

    /**
     * Despawns entity from the world.
     * That means the entity will still exist.
     */
    public void despawn(){
        this.npc.despawn();
    }

    /**
     * Sets the movement speed of the entity.
     * The speed can be set between 1-10, as 1 is the slowest and 10 is the fastest.
     * @param speed the speed of the entity in numbers
     */
    public void setEntitySpeed(int speed){
        npc.getNavigator().getLocalParameters().speedModifier(speed);
    }

    /**
     * Sets the ability of the entity to fly.
     * @param allow allows the entity to fly.
     */
    public void setFlying(boolean allow){
        npc.setFlyable(allow);
    }

    /**
     * Checks if the entity can fly
     * @return 'true' if it can fly, and 'false' if it can't
     */
    public boolean isFlying(){
        return npc.isFlyable();
    }

    /**
     * Sets if the entity will behave like minecraft's AI
     * @param use Applies minecraft's AI on the entity
     */
    public void useMinecraftAI(boolean use){
        npc.setUseMinecraftAI(use);
    }

    /***
     * Gives the NPC a skin to your choice from a player.
     * @param name The name of the player that his skin will be used
     * @param latest Determines if the API would use the latest skin associated to this player's name
     */
    public void setSkin(String name, boolean latest){
        npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, name);
        npc.data().set(NPC.PLAYER_SKIN_USE_LATEST, latest);

    }

    /**
     * Gives the NPC a skin to your choice from texture and signature.
     * @param name Name associated to the skin
     * @param texture the texture of the skin
     * @param signature the signature of the skin
     */
    public void setSkin(String name, String texture, String signature){
        npc.getTraitNullable(SkinTrait.class).setSkinPersistent(name, texture, signature);
    }

    /**
     * Targets a specific player, locates a player and follows him
     * @param target the player the NPC will target
     * @param aggressive makes the NPC aggressive towards the player, which means the NPC will hurt him and eventually will kill him.
     */
    public void targetPlayer(Player target, boolean aggressive){
        npc.getNavigator().setTarget(target, aggressive);
    }

    /**
     * Makes the NPC protected from damage, mobs, explosion, etc.
     * @param protect protects the NPC from damage.
     */
    public void setProtected(boolean protect){
        npc.setProtected(protect);
    }

    /**
     * Gets the current target of the NPC, returns null if there's no target.
     * @return The Entity it currently targets.
     */
    public Entity getCurrentTarget(){
        if(npc.getNavigator().getEntityTarget().getTarget() == null){
            return null;
        }
        return npc.getNavigator().getEntityTarget().getTarget();
    }

    /**
     * Gets the current location of the entity the NPC is targeting. might return null.
     * @return the location of the target.
     */
    public Location getCurrentTargetLocation(){
        if(npc.getNavigator().getTargetType().equals(TargetType.LOCATION)){
            return npc.getNavigator().getTargetAsLocation();
        }else{
            return null;
        }
    }

    /**
     * Saves the NPC to a local file. The NPC can be saved in 'NPCStorageManager'
     * @param dataKey the 'NPCStorageManager'
     */
    public void save(MemoryDataKey dataKey){
        npc.save(dataKey);
    }

    /**
     * Checks if the class of the entity considers it as an aggressive entity.
     * @return 'true' if the entity is aggressive, 'false' otherwise.
     */
    public boolean isAggressive(){
        return threatClass.isAggressive();
    }
    /**
     * Checks if the class of the entity considers it threatening.
     * @return 'true' if the entity is threatening, 'false' otherwise.
     */
    public boolean isThreatening(){
        return threatClass.isThreatening();
    }
}
