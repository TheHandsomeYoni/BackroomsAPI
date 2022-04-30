package net.thehandsomeyoni.backroomsapi.entities.Manager;

import net.citizensnpcs.api.util.MemoryDataKey;

/**
 * Differently from StorageManager, this class is specifically for NPC
 */
public class NPCStorageManager {
    private MemoryDataKey dataKey;

    public NPCStorageManager(){
        this.dataKey = new MemoryDataKey();
    }

    public void setStorage(MemoryDataKey dataKey){
        this.dataKey = dataKey;
    }

    public void set(String path, Object value){
        this.dataKey.setRaw(path, value);

    }

    public MemoryDataKey getStorage(){
        return this.dataKey;
    }
}
