package net.thehandsomeyoni.backroomsapi;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.MemoryDataKey;
import net.thehandsomeyoni.backroomsapi.entities.Manager.NPCStorageManager;
import net.thehandsomeyoni.backroomsapi.storage.StorageManager;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public final class BackroomsAPI {
    private Plugin plugin;
    private File file;
    private StorageManager storageManager;
    private NPCStorageManager npcStoageManager;

    /**
     * Initializes the API, and all the processes associated.
     * @param plugin the plugin which uses the API
     */
    public BackroomsAPI(Plugin plugin){
        this.plugin = plugin;
        this.npcStoageManager = new NPCStorageManager();

        file = new File(this.plugin.getDataFolder(), "backrooms.toml");
        if(!file.exists()){
            try {
                file.createNewFile();
                this.storageManager = new StorageManager(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            this.storageManager = new StorageManager(file);
        }
    }

    public StorageManager getStorageManager(){
        return storageManager;
    }

    public MemoryDataKey getNPCStorageManager(){
        return npcStoageManager.getStorage();
    }

    public NPC getEntityByID(int id){
        try{
            return CitizensAPI.getNPCRegistry().getById(id);
        } catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }

    public Plugin getPlugin(){
        return plugin;
    }
}