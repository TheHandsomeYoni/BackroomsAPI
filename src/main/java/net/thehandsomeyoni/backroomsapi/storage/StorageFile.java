package net.thehandsomeyoni.backroomsapi.storage;

import com.electronwill.nightconfig.core.file.FileConfig;

import java.io.File;

public abstract class StorageFile {
    protected FileConfig tomlFile;

    public StorageFile(File file){
        this.tomlFile = FileConfig.of(file);
    }

    public abstract FileConfig getStorage();

    public abstract void loadStorage();

    public abstract void closeStorage();

    public abstract void writeField(String path, Object info);

    public abstract void removeField(String path);

    public abstract Object getField(String path);

    public abstract void saveStorage();
}
