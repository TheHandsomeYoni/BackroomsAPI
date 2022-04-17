package net.thehandsomeyoni.backrooms;

import com.electronwill.nightconfig.core.file.FileConfig;
import net.thehandsomeyoni.backrooms.Managers.EntitiesRegistry;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * @author TheHandsomeYoni
 */
public final class Backrooms {
    private static Plugin plugin;
    private static FileConfig tomlFile;

    public Backrooms(Plugin plugin){
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

    public static final Plugin getPlugin(){
        return plugin;
    }

    public static final FileConfig getConfigurationFile(){
        return tomlFile;
    }
}
