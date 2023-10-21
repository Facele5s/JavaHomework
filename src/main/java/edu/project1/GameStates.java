package edu.project1;

public enum GameStates {
    WAITING("WAITING"),
    GAME_PROCESS("GAME_PROCESS"),
    STOP("STOP");

    private final String displayName;

    GameStates(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
