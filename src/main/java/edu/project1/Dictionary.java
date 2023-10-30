package edu.project1;

import java.util.Random;

public class Dictionary {
    private static final Random RANDOM = new Random();

    private static final String[] GAME_WORDS = new String[] {"Клён", "Кровать", "Перезагрузка",
        "Метроном", "Параллелограмм"};

    public static String getGameWord() {
        return GAME_WORDS[RANDOM.nextInt(GAME_WORDS.length)];
    }

    private Dictionary() {
    }
}
