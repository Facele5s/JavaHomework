package edu.hw9;

import edu.hw9.Task2.DirectoryFinder;
import edu.hw9.Task2.FileFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    private static final Path ROOT_TEST_DIRECTORY = Path.of("src/main/java/edu/hw9/Task2/test/");
    private static final Path DIR_1 = Path.of("src/main/java/edu/hw9/Task2/test/dir1/");
    private static final Path DIR_2 = Path.of("src/main/java/edu/hw9/Task2/test/dir2/");
    private static final Path DIR_3 = Path.of("src/main/java/edu/hw9/Task2/test/dir3/");
    private static final Path FILE_1 = Path.of("src/main/java/edu/hw9/Task2/test/bigFile.txt");
    private static final Path FILE_2 = Path.of("src/main/java/edu/hw9/Task2/test/something.db");

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Поиск папок с болшим количеством файлов")
    public void directoryWithLotOfFilesTest() throws IOException {
        generateLotOfFiles();

        DirectoryFinder finder = new DirectoryFinder(ROOT_TEST_DIRECTORY);
        ForkJoinPool pool = new ForkJoinPool();

        List<Path> directories = pool.invoke(finder);
        assertTrue(directories.contains(DIR_3));
        LOGGER.info("Папки, в которых 1000 или больше файлов: ");
        directories.forEach(dir -> LOGGER.info(dir.toString()));
    }

    @Test
    @DisplayName("Поиск файлов по предикату")
    public void findFileByPredicateTest() throws IOException {
        generateSomeFiles();

        List<Predicate<Path>> predicates = List.of(path -> {
            try {
                return Files.size(path) > 1000 && path.toString().endsWith(".txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        FileFinder finder = new FileFinder(predicates, ROOT_TEST_DIRECTORY);
        ForkJoinPool pool = new ForkJoinPool();

        List<Path> files = pool.invoke(finder);
        assertTrue(files.contains(FILE_1));
        LOGGER.info("Файлы, удовлетворяющие условиям: ");
        files.forEach(file -> LOGGER.info(file.toString()));
    }

    private static void generateLotOfFiles() throws IOException{
        if (ROOT_TEST_DIRECTORY.toFile().exists()) {
            deleteDirectory(ROOT_TEST_DIRECTORY.toFile());
        }

        Files.createDirectory(ROOT_TEST_DIRECTORY);
        Files.createDirectory(DIR_1);
        Files.createDirectory(DIR_2);
        Files.createDirectory(DIR_3);

        for (int i = 0; i < 10; i++) {
            String filePath = "src/main/java/edu/hw9/Task2/test/dir2/file" + (i + 1) + ".txt";
            Files.createFile(Path.of(filePath));
        }

        for (int i = 0; i < 1000; i++) {
            String filePath = "src/main/java/edu/hw9/Task2/test/dir3/file" + (i + 1) + ".txt";
            Files.createFile(Path.of(filePath));
        }
    }

    private static void generateSomeFiles() throws IOException {
        if (ROOT_TEST_DIRECTORY.toFile().exists()) {
            deleteDirectory(ROOT_TEST_DIRECTORY.toFile());
        }

        Files.createDirectory(ROOT_TEST_DIRECTORY);

        Files.createFile(FILE_1);
        Files.createFile(FILE_2);

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(FILE_1))) {
            IntStream.range(0, 10000).mapToObj(String::valueOf).forEach(writer::print);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean deleteDirectory(File directory) {
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File file : contents) {
                deleteDirectory(file);
            }
        }
        return directory.delete();
    }
}
