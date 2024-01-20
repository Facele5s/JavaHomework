package edu.hw6.Task1;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final FileHandler fileHandler;

    public DiskMap(String filePath) throws IOException, WrongFileFormatException {
        File file = new File(filePath);

        if (!file.exists()) {
            file.createNewFile();
        }

        fileHandler = new FileHandler(file);
        if (!fileHandler.checkFileFormat()) {
            throw new WrongFileFormatException();
        }
    }

    @Override
    public int size() {
        return keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return keySet().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains((String) key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains((String) value);
    }

    @Override
    public String get(Object key) {
        return fileHandler.readValueByKey((String) key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String oldValue = fileHandler.writeToTemp(key, List.of(value));

        fileHandler.loadFromTemp();
        fileHandler.deleteTemp();

        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = fileHandler.writeToTemp((String) key, null);

        fileHandler.loadFromTemp();
        fileHandler.deleteTemp();

        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) { // TODO: 16.11.2023
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        fileHandler.clearFile();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return fileHandler.readKeys();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return fileHandler.readValues();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return fileHandler.readEntrySets();
    }


}
