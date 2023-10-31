package edu.project1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class HangmanGame {
    private static final int DEFAULT_NUMBER_OF_ATTEMPTS = 7;

    private GameStates gameState = GameStates.WAITING;
    private String word;
    private char[] hiddenSymbols;
    private int numberOfAttempts;
    private int numberOfRemainingChars;
    private final Set<Character> usedChars = new TreeSet<>();

    public void setWord(String word) {
        this.word = word;
        hiddenSymbols = new char[word.length()];
        Arrays.fill(hiddenSymbols, '*');
        numberOfRemainingChars = hiddenSymbols.length;
    }

    public void initSession() {
        numberOfAttempts = DEFAULT_NUMBER_OF_ATTEMPTS;
        usedChars.clear();
    }

    public void setGameState(GameStates gameState) {
        this.gameState = gameState;
    }

    public String getWord() {
        return word;
    }

    public Set<Character> getUsedChars() {
        return usedChars;
    }

    public GameStates getGameState() {
        return gameState;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getNumberOfRemainingChars() {
        return numberOfRemainingChars;
    }

    public char[] getHiddenSymbols() {
        return hiddenSymbols;
    }

    public boolean wordContainsChar(char attempt) {
        usedChars.add(Character.toUpperCase(attempt));

        for (int i = 0; i < word.length(); i++) {
            if (Character.toUpperCase(attempt) == Character.toUpperCase(word.charAt(i))) {
                openCharacter(attempt);
                return true;
            }
        }

        numberOfAttempts--;
        return false;
    }

    private void openCharacter(char opening) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toUpperCase(opening) == Character.toUpperCase(word.charAt(i))) {
                hiddenSymbols[i] = word.charAt(i);
                numberOfRemainingChars--;
            }
        }
    }

    public boolean isCharUsed(char c) {
        return usedChars.contains(Character.toUpperCase(c));
    }

}
