package edu.project1;

import java.util.List;

public interface GameControls {
    void startGame();

    void playGame();

    List<String> testGame(String word, String inputs, ObservingParams param);

    void stopGame();

    void winGame();

    void loseGame();

    void makeAttempt(char attempt);

    String readInput();
}
