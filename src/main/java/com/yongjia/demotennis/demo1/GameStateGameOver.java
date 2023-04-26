package com.yongjia.demotennis.demo1;

public class GameStateGameOver extends GameState {
    public GameStateGameOver(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return tennisGame.getPlayer1Point() > tennisGame.getPlayer2Point()?
                String.format("%s Won", tennisGame.getPlayer1()):
                String.format("%s Won", tennisGame.getPlayer2());
    }
}
