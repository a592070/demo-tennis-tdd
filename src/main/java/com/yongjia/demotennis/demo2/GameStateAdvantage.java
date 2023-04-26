package com.yongjia.demotennis.demo2;

public class GameStateAdvantage extends GameState {
    public GameStateAdvantage(TennisGame tennisGame) {
        super(tennisGame);
    }

    @Override
    public String getDisplayScore() {
        return tennisGame.getPlayer1Point() > tennisGame.getPlayer2Point()?
                String.format("%s advantage", tennisGame.getPlayer1()):
                String.format("%s advantage", tennisGame.getPlayer2());
    }
}
