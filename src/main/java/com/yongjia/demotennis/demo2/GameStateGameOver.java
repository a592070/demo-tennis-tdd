package com.yongjia.demotennis.demo2;

public class GameStateGameOver extends GameState {
    public GameStateGameOver(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return tennisGame.getPlayer1Point() > tennisGame.getPlayer2Point()?
                String.format("%s won", tennisGame.getPlayer1()):
                String.format("%s won", tennisGame.getPlayer2());
    }
}
