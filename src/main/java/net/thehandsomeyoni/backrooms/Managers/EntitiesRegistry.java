package net.thehandsomeyoni.backrooms.Managers;

import net.thehandsomeyoni.backrooms.Backrooms;
import net.thehandsomeyoni.backrooms.abstracts.BackroomsEntity;
import org.bukkit.Bukkit;

public class EntitiesRegistry {

    public void registerEntity(BackroomsEntity entity){
            Backrooms.getConfigurationFile().set(String.valueOf(entity.getNPC().getId()), entity);
    }

    public void unregisterEntity(BackroomsEntity entity){
        try{
            Backrooms.getConfigurationFile().remove(String.valueOf(entity.getNPC().getId()));
        }catch (NullPointerException e){
            Bukkit.getLogger().warning("Error! Could not find the requested entity.");
            e.printStackTrace();
        }

    }

    public void unregisterEntity(int id){
        try{
            Backrooms.getConfigurationFile().remove(String.valueOf(id));
        }catch (NullPointerException e){
            Bukkit.getLogger().warning("Error! Could not find the requested entity.");
            e.printStackTrace();
        }

    }

    public BackroomsEntity getEntity(int id){
        BackroomsEntity entity = Backrooms.getConfigurationFile().get(String.valueOf(id));
        return entity;
    }

}
