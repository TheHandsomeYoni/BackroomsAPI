package net.thehandsomeyoni.backroomsapi;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.thehandsomeyoni.backroomsapi.Managers.EntitiesRegistry;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class BackroomsAPI {

    private static JavaPlugin plugin;
    private static FileConfig tomlFile;

    public BackroomsAPI(JavaPlugin plugin){
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