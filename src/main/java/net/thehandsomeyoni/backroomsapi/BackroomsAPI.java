package net.thehandsomeyoni.backroomsapi;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.thehandsomeyoni.backroomsapi.Managers.EntitiesRegistry;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public final class BackroomsAPI {

    private static Plugin plugin;
    private static FileConfig tomlFile;

    public BackroomsAPI(Plugin plugin){
        this.plugin = plugin;
        File file = new File(this.plugin.getDataFolder(), "backrooms.toml");
        if(!file.exists()){
            try {
                file.createNewFile();
                tomlFile = FileConfig.of(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            tomlFile = FileConfig.of(file);
        }
    }

    public FileConfig getCOnfigurationFile(){
        return this.tomlFile;
    }

    public EntitiesRegistry getEntitiesRegistry(){
        return new EntitiesRegistry();
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    public static FileConfig getConfigurationFile(){
        return tomlFile;
    }


}