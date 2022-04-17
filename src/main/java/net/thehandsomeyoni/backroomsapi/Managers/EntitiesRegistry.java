package net.thehandsomeyoni.backroomsapi.Managers;

import net.thehandsomeyoni.backroomsapi.BackroomsAPI;
import net.thehandsomeyoni.backroomsapi.abstracts.BackroomsEntity;
import org.bukkit.Bukkit;

public class EntitiesRegistry {

    public void registerEntity(BackroomsEntity entity){
            BackroomsAPI.getConfigurationFile().set(String.valueOf(entity.getNPC().getId()), entity);
    }

    public void unregisterEntity(BackroomsEntity entity){
        try{
            BackroomsAPI.getConfigurationFile().remove(String.valueOf(entity.getNPC().getId()));
        }catch (NullPointerException e){
            Bukkit.getLogger().warning("Error! Could not find the requested entity.");
            e.printStackTrace();
        }

    }

    public void unregisterEntity(int id){
        try{
            BackroomsAPI.getConfigurationFile().remove(String.valueOf(id));
        }catch (NullPointerException e){
            Bukkit.getLogger().warning("Error! Could not find the requested entity.");
            e.printStackTrace();
        }

    }

    public BackroomsEntity getEntity(int id){
        BackroomsEntity entity = BackroomsAPI.getConfigurationFile().get(String.valueOf(id));
        return entity;
    }

}
