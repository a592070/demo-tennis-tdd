package com.yongjia.demotennis.demo2;

public class GameStateDeuce extends GameState {
    public GameStateDeuce(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return "deuce";
    }
}
