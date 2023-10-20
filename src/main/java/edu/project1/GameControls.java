package edu.project1;

public interface GameControls {
    void startGame();

    void playGame();

    void stopGame();

    void winGame();

    void loseGame();

    void startTest();

    void makeAttempt(char attempt);

    String readInput();
}
