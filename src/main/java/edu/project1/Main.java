package edu.project1;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        GameController gameController = new GameController(new HangmanGame(), System.in);
        gameController.startGame();
    }
}
