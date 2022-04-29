package net.thehandsomeyoni.backroomsapi.storage;

import com.electronwill.nightconfig.core.file.FileConfig;

import java.io.File;

public final class StorageManager extends StorageFile {
    /**
     * Constructor that initializes the storage.
     * @param file the file where info is going to  be stored. Currently: "backrooms.toml"
     */
    public StorageManager(File file) {
        super(file);
    }

    /**
     * Gets the storage where information is going to be stored.
     * @return the storage where info is going to be stored.
     */
    @Override
    public FileConfig getStorage() {
        return tomlFile;
    }

    /**
     * Loads the storage in case it's not initialized.
     */
    @Override
    public void loadStorage() {
        tomlFile.load();
    }

    /**
     * Saves and closes the storage, which means it's uneditable, until you'll load it again.
     */
    @Override
    public void closeStorage() {
        tomlFile.save();
        tomlFile.close();
    }

    /**
     * Writes a field in the storage on the specified path.
     * @param path the path where info is going to be written.
     * @param info can either be a string, number, list, or boolean.
     */
    @Override
    public void writeField(String path, Object info) {

        tomlFile.set(path, info);
    }

    /**
     * Removes a field from the storage.
     * @param path the path which is going to be removed
     */
    @Override
    public void removeField(String path) {
        tomlFile.remove(path);
    }

    /**
     * Gets the specified path
     * @param path the path to retrieve.
     * @return the value of the path.
     */
    @Override
    public Object getField(String path) {
        return tomlFile.get(path);
    }

    /**
     * Saves the storage to avoid any loss of information. Auto save might arrive soon.
     */
    @Override
    public void saveStorage() {
        tomlFile.save();
    }
}
