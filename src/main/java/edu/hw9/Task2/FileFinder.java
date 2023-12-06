package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class FileFinder extends RecursiveTask<List<Path>> {
    private final List<Predicate<Path>> predicates;

    private final Path currentPath;

    public FileFinder(List<Predicate<Path>> predicates, Path currentPath) {
        this.predicates = predicates;
        this.currentPath = currentPath;
    }

    @Override
    protected List<Path> compute() {
        if (!Files.isReadable(currentPath)) {
            return Collections.emptyList();
        }

        List<DirectoryFinder> directories = new ArrayList<>();
        List<Path> response = new ArrayList<>();

        try {
            Files.list(currentPath).forEach(thing -> {
                if (Files.isDirectory(thing)) {
                    directories.add(new DirectoryFinder(thing));
                } else {
                    if (predicates.stream().allMatch(predicate -> predicate.test(thing))) {
                        response.add(thing);
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        directories.forEach(directory -> {
            response.addAll(directory.join());
        });

        return response;
    }
}
