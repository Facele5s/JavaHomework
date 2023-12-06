package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class DirectoryFinder extends RecursiveTask<List<Path>> {
    private static final int FILES_COUNT_REQUIREMENT = 1000;

    private final Path currentPath;

    public DirectoryFinder(Path currentPath) {
        this.currentPath = currentPath;
    }

    @Override
    protected List<Path> compute() {
        if (!Files.isReadable(currentPath)) {
            return Collections.emptyList();
        }

        AtomicInteger fileCount = new AtomicInteger(0);
        List<DirectoryFinder> directories = new ArrayList<>();

        try {
            Files.list(currentPath).forEach(thing -> {
                if (Files.isDirectory(thing)) {
                    directories.add(new DirectoryFinder(thing));
                } else {
                    fileCount.getAndIncrement();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Path> response = new ArrayList<>();
        if (fileCount.get() >= FILES_COUNT_REQUIREMENT) {
            response.add(currentPath);
        }

        directories.forEach(directory -> {
            response.addAll(directory.join());
        });

        return response;
    }
}
