package edu.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private static final Random RANDOM = new Random();
    private final List<String> gameWords = new ArrayList<>();

    public Dictionary(String filePath) throws FileNotFoundException, WrongInputFormatException, NoSuchElementException {
        Scanner scanner = new Scanner(new FileInputStream(filePath));
        scanner.nextLine(); // Пропустить строку с объяснениями в файле

        if (!scanner.hasNextLine()) {
            throw new NoSuchElementException("Файл с игровыми словами пуст");
        }

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();

            for (char c : word.toCharArray()) {
                if (!Character.isLetter(c)) {
                    throw new WrongInputFormatException("Файл с игровыми словами неверно заполнен");
                }
            }

            gameWords.add(word);
        }
    }

    public String getGameWord() {
        return gameWords.get(RANDOM.nextInt(gameWords.size()));
    }
}
